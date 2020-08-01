package com.lcyj.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {

    public final static String[] DATE_F = {"yyyy-MM-dd","yyyy/MM/dd","yyyyMMdd","yyyy年MM月dd日","yyyy年MM月dd","MM月dd日"};
    /** 默认的日期格式 */
    public final static String DATE_DEFAULT = "yyyy-MM-dd";
    private static String REG_DATE_F ;

    static{

    }

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
        return format.format(date);
    }

    public static String dateToStr(Date date) {
        return dateToStr(date,DATE_DEFAULT);
    }

    /**
     * 解析字符串对象到日期对象
     * @param str
     * @return
     */
    public static Date resolveStrToDate(String str) throws ParseException {
        Date date = null;
        for(String df : DateUtils.DATE_F){
            date = strToDate(str, df);
        }
        return date;
    }

    /**
     * 解析字符串
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date parseStrToDate(String str){
        Date date = null;
        for(String df : DateUtils.DATE_F){
            try {
                date = strToDate(str, df);
                if(date != null){
                    break;
                }
            } catch (ParseException e) {
            }
        }
        return date;
    }

    /**
     * 从给定的字符串中解析出指定的日期
     * @param targetStr
     * @return
     */
    public static List<String> resolveDateOfStr(String targetStr){
        return resolveDateOfStr(targetStr,REG_DATE_F);
    }

    /**
     * 从给定的字符串中解析出指定的日期
     * @param targetStr 目标字符
     * @param patStr 模板
     * @return
     */
    public static List<String> resolveDateOfStr(String targetStr,String patStr){
        Pattern p = Pattern.compile(patStr);
        Matcher m = p.matcher(targetStr);
        List<String> list = new ArrayList();
        while(m.find()){
            list.add(m.group());
        }
        return list;
    }

    static class TIMEZONE{
        /** 世界时UT即格林尼治平太阳时间，是指格林尼治所在地的标准时间 */
        public static final String GMT = "GMT+8";

    }
}
