package com.hexiaofei.provider0.utils;

import org.joda.time.DateTime;
import org.joda.time.chrono.GregorianChronology;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/** 
* DateUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>Jan 30, 2020</pre> 
* @version 1.0 
*/ 
public class DateUtilsTest {

     

    @Before
    public void before() throws Exception { 
    
    } 

    @After
    public void after() throws Exception { 
    
    } 

    /** 
    * 
    * Method: strToDate(String str, String pattern) 
    * 
    */ 
    @Test
    public void testStrToDateForStrPattern() throws Exception { 
    
    
    } 

    /** 
    * 
    * Method: dateToStr(Date date, String pattern) 
    * 
    */ 
    @Test
    public void testDateToStr() throws Exception {
        System.out.println("日期转字符串：" + DateUtils.dateToStr(new Date(),"yyyy-MM-dd"));
    }

    /** 
    * 
    * Method: strToDate(String str) 
    * 
    */ 
    @Test
    public void testStrToDateStr() throws Exception {
        Date date = strToDate("1856-07-10", "yyyy-MM-dd");
        System.out.println("字符串转日期：" + date);
    }



    public static Date strToDate(String str,String pattern) throws ParseException {

        DateFormat format = new SimpleDateFormat(pattern);

        format.setTimeZone(TimeZone.getTimeZone("CCT+8"));
        Date date = format.parse(str);

        return date;
    }

    @Test
    public void test(){
        int year = 1900;
        DateTime dt = new DateTime(year, 1,1,0,0,0,0);
     //   dt = dt.toDateTime(GregorianChronology.getInstance());

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, 0, 1, 0, 0, 0);

        DateTime endDate = new DateTime(cal.getTimeInMillis());
        endDate = endDate.toDateTime(GregorianChronology.getInstance());

        System.out.println("JodaTime: " + dt);
        System.out.println("JodaTime, ms: " + dt.getMillis());
        System.out.println("Calendar: " + cal.getTime());
        System.out.println("Calendar, ms: " + cal.getTimeInMillis());
        System.out.println("JodaTime by Calendar: " + endDate);
    }


}
