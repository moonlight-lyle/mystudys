package com.it.reflection;

import com.it.Vo.Student;
import org.junit.Test;

/**
 * 获取字节码对象的三种方式
 *注意：一个类只有唯一的一个字节码对象
 * @author Lyle
 * @date 2020/11/14
 */
public class GetClassObject {


    /**
     * 方式一：Class.forName("")方法获取：括号中写类的全路径名称
     */

    /**
     * 方式二：类名.Class
     */

    /**
     * 方式三:对象名.class
     */

    @Test
    public void getMethod01() throws ClassNotFoundException {
        //方式一获取
        Class<?> aClass01 = Class.forName("com.it.Vo.Student");
        //方式二获取
        Class<Student> aClass02 = Student.class;
        //方式三获取
        Student student=new Student();
        Class<? extends Student> aClass03 = student.getClass();
        //验证一个类只有唯一的字节码对象：三个对象的地址值相同
        System.out.println(aClass01.equals(aClass02));
        System.out.println(aClass01.equals(aClass03));
        System.out.println(aClass02.equals(aClass03));

    }







}
