package com.it.annotation;

/**
 * 自定义注解
 *
 * @author Lyle
 * @date 2020/11/14
 */
public @interface myAnnotation {
    //可写的数据类型:基本类型，String，枚举，注解，Class类型
    //int a();  //注意，定义了注解，使用注解时必须赋值
    String[] arr();
}
