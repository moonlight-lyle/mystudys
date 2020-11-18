package com.it.Vo;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/11/14
 */
public class Student {

    public String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("吃饭了。。。。。");
    }

    public void eat(int n) {
        System.out.println("吃了" + n + "顿饭，吃撑了。。。。");
    }

    private void sleep(int hour, String sleepStyle) {
        System.out.println(name + "今天使用" + sleepStyle + ",睡了" + hour + "小时，舒服极了。。。");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
