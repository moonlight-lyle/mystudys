package com.it.reflection;

import com.it.Vo.Apple;
import com.it.Vo.Fruit;
import com.it.Vo.Watermelon;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 反射的简单应用
 *
 * @author Lyle
 * @date 2020/11/14
 */
public class ReflectionApplication {

    @Test
    public void fun01() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //juicer()方法中传入哪个对象，通过配置文件定义，读取配置文件反射创建对象
        /**
         * 步骤：
         * 1.创建配置文件Properties对象
         * 2.加载配置文件中的信息 --load
         * 3.通过getProperties()方法获取到水果的全路径类名
         * 4.通过反射创建对象
         */
        Properties properties = new Properties();
        FileInputStream fis=new FileInputStream("src\\main\\resources\\fruit.properties");
        properties.load(fis);
        //获取全路径类名
        String fruitClass = properties.getProperty("fruitClass");
        //通过全路径类名获取字节码对象
        Class aClass = Class.forName(fruitClass);
        //通过字节码对象，使用空参构造创建实例
        Apple apple = (Apple) aClass.newInstance();
        //调用方法
        juicer(apple);
        System.out.println("程序运行。。。。");
    }

    /**
     * 此方法用于模拟榨汁机
     */
    public void juicer(Fruit fruit){
        fruit.juice();
    }
}
