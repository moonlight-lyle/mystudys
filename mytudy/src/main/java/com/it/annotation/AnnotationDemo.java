package com.it.annotation;

import org.junit.Test;

/**
 *自定义注解的简单使用
 *
 * @author Lyle
 * @date 2020/11/14
 */
public class AnnotationDemo {

    @Test
    @myAnnotation(arr={"a","b"})
    public void fun(){

    }
}
