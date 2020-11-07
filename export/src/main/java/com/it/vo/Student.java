package com.it.vo;

import java.util.Date;

import com.it.annotation.ExcelAnnotation;
import lombok.Data;

@Data
public class Student {

    private Long id;
    @ExcelAnnotation(headName = "学号", order = 0)
    private String stuNo;
    @ExcelAnnotation(headName = "姓名", order = 1)
    private String name;
    @ExcelAnnotation(headName = "学院", order = 3)
    private String academy;
    @ExcelAnnotation(headName = "专业", order = 4)
    private String major;
    @ExcelAnnotation(headName = "年级", order = 5)
    private String grade;
    @ExcelAnnotation(headName = "班级", order = 6)
    private String classes;
    @ExcelAnnotation(headName = "年龄", order = 2)
    private String age;
    @ExcelAnnotation(headName = "入学日期", order = 7, datePattern = "yyyy/MM/dd HH:mm:ss", type = ExcelAnnotation.DataType.Date)
    private Date entryDate;

}