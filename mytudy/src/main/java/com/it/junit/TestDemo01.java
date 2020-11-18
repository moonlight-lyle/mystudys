package com.it.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

/**
 * 单元测试 junit
 *
 * @author Lyle
 * @date 2020/11/13
 */
public class TestDemo01 {

    @Test
    public void fun01(){
        System.out.println("junit测试01。。。");
    }

    @Test
    public void fun02(){
        System.out.println("junit测试02。。。");
    }

    /**
     * 单元测试其他注解
     * 在Junit5下使用@BeforeEach和@AfterEach
     * 1.@BeforeEach：执行单元测试前会自动执行的方法
     * 2.@AfterEach：执行单元测试后会自动执行的方法
     * 3.@BeforeClass：写在静态方法上，所有方法执行前执行这个方法
     * 4.@AfterClass：写在静态方法上，所有方法执行后执行这个方法
     */

    @BeforeEach
    public void beforeTestMethod(){
        System.out.println("执行单元测试前会执行的方法。。。");
    }

    @AfterEach
    public void afterTestMethod(){
        System.out.println("执行单元测试后会执行的方法。。。");
    }

    @BeforeAll
    public static void beforeAllTestMethods(){
        System.out.println("所有单元测试方法执行之前会执行的方法。。。");
    }

    @AfterAll
    public static void afterAllTestMethods(){
        System.out.println("所有测试方法执行之后会执行的方法。。。");
    }






}
