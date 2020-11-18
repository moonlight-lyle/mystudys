package com.it.junit;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/11/13
 */
public class CalculatorTest extends TestCase {

    @Test
    public void testGetSum(){
        Calculator c=new Calculator();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        int sum=c.getSum(list);
        //结果55
        //System.out.println(sum);
        //断言
        Assert.assertEquals("计算结果有误！！！",55,sum);
    }

}