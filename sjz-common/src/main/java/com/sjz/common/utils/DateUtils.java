package com.sjz.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public final static String[] DATE_F = {"yyyy-MM-dd","yyyy年MM月dd日","yyyy/MM/dd"};

    public static Date strToDate(String str,String pattern) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;

        date = format.parse(str);

        return date;
    }

    public static String dateToStr(Date date,String pattern) {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String str = format.format(date);
        return str;
    }

    public static Date strToDate(String str){
        Date date = null;
        for(String df : DateUtils.DATE_F){
            try {
                date = DateUtils.strToDate(str, df);
            } catch (ParseException e) {
            }
        }
        return date;
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println("日期转字符串：" + DateUtils.dateToStr(date,"yyyy-MM-dd"));
        System.out.println("字符串转日期：" + DateUtils.strToDate("2019-09-10", "yyyy-MM-dd"));
    }
}
