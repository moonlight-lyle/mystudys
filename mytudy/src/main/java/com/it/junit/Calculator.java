package com.it.junit;



import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Member;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 模拟计算器
 *
 * @author Lyle
 * @date 2020/11/13
 */
public class Calculator {

    /**
     * 求和
     * @param list
     * @return
     */
    public int getSum(List<Integer> list){
        int sum=0;
        if (CollectionUtils.isEmpty(list)){
            return sum;
        }
        for (Integer i : list) {
            sum+=i;
        }
        return sum;
    }
}
