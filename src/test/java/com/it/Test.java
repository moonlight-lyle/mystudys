package com.it;

import java.util.ArrayList;
import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/7/12
 */
public class Test {

    @org.junit.Test
    public void test1(){
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        List<String> list3=new ArrayList<>();
        list1.add("独孤九剑");
        list1.add("葵花宝典");
        list1.add("辟邪剑谱");

        /*list2.add("寒冰掌");
        list2.add("降龙十八掌");
        list2.add("九阴真经");*/
        boolean flag3 = list1.retainAll(list2);
        System.out.println(flag3);
        if (list1.size()>0){
            System.out.println("list1和list2有交集");
        }else {
            System.out.println("list1和list2无交集");
        }
    }
}
