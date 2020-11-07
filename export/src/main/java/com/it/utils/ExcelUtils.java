package com.it.utils;

import com.it.annotation.ExcelAnnotation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by linjiaming
 */
public class ExcelUtils {

    private static ExcelUtils instance;

    private ExcelUtils() {
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static ExcelUtils getInstance() {
        if (instance == null) {
            instance = new ExcelUtils();
        }
        return instance;
    }

    /**
     * excel的导出
     *
     * @param out
     * @param infos
     */
    public void exportExcel(OutputStream out, List<?> infos) {
        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            XSSFSheet sheet = xssfWorkbook.createSheet();
            sheet.createRow(0);

            Map<Field, Integer> map = new LinkedHashMap<Field, Integer>();
            for (Object o : infos) {
                Field[] fields = o.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(ExcelAnnotation.class)) {
                        ExcelAnnotation annotation = field.getAnnotation(ExcelAnnotation.class);
                        map.put(field, annotation.order());
                    }
                }
            }
            List<Map.Entry<Field, Integer>> list = new ArrayList<Map.Entry<Field, Integer>>(map.entrySet());
            Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

            List<Field> excelFields = new ArrayList<>();
            for (Map.Entry<Field, Integer> map1 : list) {
                excelFields.add(map1.getKey());
            }

            List<ExcelAnnotation> annotations = new ArrayList<>();
            for (Field excelField : excelFields) {
                annotations.add(excelField.getAnnotation(ExcelAnnotation.class));
            }
            addDataToExcel(xssfWorkbook, infos, excelFields, annotations, sheet);
            xssfWorkbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> void addDataToExcel(XSSFWorkbook wb, List<T> dataset, List<Field> excelFields, List<ExcelAnnotation> attributes,
                                    Sheet sheet)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ParseException {
        XSSFCellStyle style = wb.createCellStyle();
        // 居中
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        // excel放入第一行列的名称
        Row row = sheet.createRow(0);
        for (int j = 0; j < excelFields.size(); j++) {
            Cell cell = row.createCell(j);
            ExcelAnnotation oneAttribute = attributes.get(j);
            cell.setCellValue(oneAttribute.headName());
            cell.setCellStyle(style);
        }
        // 添加数据到excel
        for (int i = 0; i < dataset.size(); i++) {
            // 数据行号从1开始,因为第0行放的是列的名称
            row = sheet.createRow(i + 1);
            for (int j = 0; j < attributes.size(); j++) {
                Cell cell = row.createCell(j);
                ExcelAnnotation annotation = attributes.get(j);
                style = wb.createCellStyle();
                // 居中
                style.setAlignment(HorizontalAlignment.CENTER);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                // 四个边框
                style.setBorderBottom(BorderStyle.THIN);
                style.setBorderLeft(BorderStyle.THIN);
                style.setBorderRight(BorderStyle.THIN);
                style.setBorderTop(BorderStyle.THIN);
                cell.setCellStyle(style);
                // 根据属性名获取属性值
                String cellValue = BeanUtils.getProperty(dataset.get(i), excelFields.get(j).getName());
                if (ExcelAnnotation.DataType.Date.equals(annotation.type())) {
                    String date = null;
                    try {
                        date = DateTimeUtil
                                .getFormatDateFromGLWZString(cellValue, annotation.datePattern());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    cell.setCellValue(date);
                } else {
                    cell.setCellValue(cellValue);
                }
            }
        }

    }

    /**
     * excel的导入
     *
     * @param inputStream
     * @param clazz
     * @return
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public List<?> importExcel(InputStream inputStream, Class<?> clazz)
            throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        Row titleCell = sheet.getRow(0);
        List<Object> dataList = new ArrayList<>(sheet.getLastRowNum());
        Object datum;
        Map<String, Field> fieldMap = getFieldMap(clazz);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            datum = clazz.newInstance();
            int minCell = row.getFirstCellNum();
            int maxCell = row.getLastCellNum();
            for (int cellNum = minCell; cellNum <= maxCell; cellNum++) {
                Cell title = titleCell.getCell(cellNum);
                if (title == null) {
                    continue;
                }
                String tag = title.getStringCellValue();
                Field field = fieldMap.get(tag);
                if (field == null) {
                    continue;
                }
                Class<?> type = field.getType();
                Object value = null;
                Cell cell = row.getCell(cellNum);
                if (cell == null) {
                    continue;
                }
                if (type.equals(Date.class)) {
                    value = cell.getDateCellValue();
                } else {
                    value = cell.getStringCellValue();
                }
                PropertyUtils.setProperty(datum, field.getName(), value);
            }
            dataList.add(datum);
        }
        return dataList;
    }

    /**
     * key :headName  val:该名称对应的字段
     *
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> Map<String, Field> getFieldMap(Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Field> fieldMap = new HashMap<String, Field>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelAnnotation.class)) {
                ExcelAnnotation annotation = field.getAnnotation(ExcelAnnotation.class);
                fieldMap.put(annotation.headName(), field);
            }
        }
        return fieldMap;
    }
}