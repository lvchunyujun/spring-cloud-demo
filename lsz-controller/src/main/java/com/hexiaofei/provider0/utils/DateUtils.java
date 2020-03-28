package com.hexiaofei.provider0.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {



    public final static String[] DATE_F = {"yyyy-MM-dd","yyyy年MM月dd日","yyyy/MM/dd"};

    /** 默认的日期格式 */
    public final static String DATE_DEFAULT = "yyyy-MM-dd";

    /**
     * 字符串对象（String）转换成日期对象（Date）
     * @param str 字符串对象
     * @param pattern 日期格式： yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str,String pattern) throws ParseException {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.parse(str);
    }

    /**
     * 字符串对象（String）转换成日期对象（Date）
     * @param str 字符串对象
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str) throws ParseException {
        return strToDate(str,DATE_DEFAULT);
    }

    /**
     * 日期对象（Date）转换成字符串(String)对象
     * @param date 日期对象
     * @param pattern 日期格式： yyyy-MM-dd
     * @return
     */
    public static String dateToStr(Date date,String pattern) {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String str = format.format(date);
        return str;
    }

    /**
     *
     * @param str
     * @return
     */
    public static Date resolveStrToDate(String str){
        Date date = null;
        for(String df : DateUtils.DATE_F){
            try {
                date = DateUtils.strToDate(str, df);
            } catch (ParseException e) {
            }
        }
        return date;
    }

    static class TIMEZONE{
        /** 世界时UT即格林尼治平太阳时间，是指格林尼治所在地的标准时间 */
        public static final String GMT = "GMT+8";
    }
}
