package com.it.reflection;

import com.it.Vo.Student;
import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.FormatFlagsConversionMismatchException;

/**
 * 使用反射创建对象
 *
 * @author Lyle
 * @date 2020/11/14
 */
public class NewObjectWithReflection {

    /**
     * 使用空参构造创建对象
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void fun01() throws IllegalAccessException, InstantiationException {
        //获取字节码对象
        Class aClass = Student.class;
        //使用空参构造创建对象
        Student instance1 = (Student) aClass.newInstance();
        System.out.println(instance1);
    }

    /**
     * 反射使用有参构造创建对象
     * @throws Exception
     */
    @Test
    public void fun02() throws Exception {
        //使用有参构造创建对象
        Class student = Student.class;
        //参数写构造方法中的数据类型.class，注意顺序不能写错
        Constructor constructor = student.getConstructor(String.class, int.class);
        Student instance = (Student) constructor.newInstance("张三", 18);
        System.out.println(instance);

    }

    /**
     * 反射获取公有成员变量
     */
    @Test
    public void fun03() throws Exception {
        Class student = Student.class;

        Student s = (Student) student.newInstance();
        System.out.println(s);
        //获取公有变量
        Field name = student.getField("name");
        //设置变量值：参数为对象和值
        name.set(s,"黎姿");
        System.out.println(s);
    }

    /**
     * 反射获取私有成员变量
     */
    @Test
    public void fun04() throws Exception {
        Class student = Student.class;

        Student s = (Student) student.newInstance();
        System.out.println(s);
        //获取私有变量
        Field age = student.getDeclaredField("age");
        //去除私有权限，暴力反射
        age.setAccessible(true);
        //设置变量值：参数为对象和值
        age.set(s,18);
        System.out.println(s);
    }

    /**
     * 反射获取成员方法
     */
    @Test
    public void fun05() throws Exception {
        Class student = Student.class;

        Student s = (Student) student.newInstance();
        System.out.println(s);
        //获取成员方法
        Method eat = student.getMethod("eat", int.class);
        Method eat1 = student.getMethod("eat");
        //设置变量值：参数为对象和值
        System.out.println(eat.getName());
        System.out.println("***********获取所有的方法************");
        //获取所有的方法
        Method[] methods = student.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("==================成员方法的调用===================");
        eat1.invoke(s);
        eat.invoke(s,5);
    }

    /**
     * 反射获取私有成员方法
     */
    @Test
    public void fun06() throws Exception {
        //字节码对象
        Class student = Student.class;

        //获取有参构造方法
        Constructor constructor = student.getConstructor(String.class, int.class);
        //调用有参构造创建对象
        Student instance = (Student) constructor.newInstance("刘星", 22);
        //获取私有方法
        Method sleep = student.getDeclaredMethod("sleep", int.class, String.class);
        //去除私有属性
        sleep.setAccessible(true);
        sleep.invoke(instance,8,"葛优躺");
    }

}
