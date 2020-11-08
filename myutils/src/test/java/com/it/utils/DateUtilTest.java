package com.it.utils;

import com.it.utils.DateUtil;
import org.junit.Test;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/11/7
 */
public class DateUtilTest {

    @Test
    public void getLastDayOfMonthTest(){
        String monthStr="2020-10";
        String lastDayOfMonth = DateUtil.getLastDayOfMonth(monthStr);
        System.out.println(lastDayOfMonth);
    }
}
