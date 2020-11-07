package com.it.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
public class DateTimeUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
 
    /**
     * 获得所需要的日期格式
     *
     * @param date
     * @param format yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getFormatDateFromString(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date formatDate = null;
        try {
            formatDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }
    
    public static String getFormatDateFromGLWZString(String strdate, String format)
            throws ParseException {
 
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
 
        Date date =df.parse(strdate);
 
//     System.out.println(date.toString());
 
        SimpleDateFormat sdf=new SimpleDateFormat(format);
 
        return sdf.format(date);
 
    }
}