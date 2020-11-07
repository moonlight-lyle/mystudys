import com.it.utils.ExcelUtils;
import com.it.vo.Student;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 导出测试
 *
 * @author Lyle
 * @date 2020/11/7
 */
public class ExportTest {
    @Test
    public void fun()
            throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ExcelUtils excelUtils = ExcelUtils.getInstance();
        String filepath = "D:\\学生信息表.xlsx";
        File file = new File(filepath);

        List<?> objects = excelUtils.importExcel(new FileInputStream(file), Student.class);
        System.out.println(objects);
    }


    @Test
    public void fun2()
            throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ExcelUtils excelUtils = ExcelUtils.getInstance();
        String filepath = "D:\\学生信息表2.xlsx";
        File file = new File(filepath);
        OutputStream fileOutputStream = new FileOutputStream(file);
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setStuNo("1");
        student.setName("张三");
        student.setAcademy("机械");
        student.setGrade("大二");
        student.setMajor("计算机");
        student.setGrade("100");
        student.setAge("20");
        student.setClasses("7班");
        student.setEntryDate(new Date());

        Student student2 = new Student();
        student2.setStuNo("2");
        student2.setName("李四");
        student2.setAcademy("机械");
        student2.setGrade("大二");
        student2.setMajor("计算机");
        student2.setGrade("100");
        student2.setAge("20");
        student2.setClasses("7班");
        student2.setEntryDate(new Date());

        Student student3 = new Student();
        student3.setStuNo("3");
        student3.setName("王五");
        student3.setAcademy("计算机");
        student3.setGrade("大二");
        student3.setMajor("计算机");
        student3.setGrade("90");
        student3.setAge("22");
        student3.setClasses("8班");
        student3.setEntryDate(new Date());

        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        excelUtils.exportExcel(fileOutputStream, studentList);
    }
}
