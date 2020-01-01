package com.hexiaofei.sjzclient.utils;


import com.hexiaofei.sjzclient.exception.IllegalPlatformAugumentException;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @since v1.1
 * @history
 * @see
 */
public class DateUtil
{
    /**
     * 将时间转成"yyyy-MM-dd"格式的字符串
     * 
     * @param date
     *            时间
     * @return
     * 
     */
    public static String formatToYYYYMMDD(Date date)
    {
        if(date!=null)
        {
            return YZYDateFormat.getInstance("yyyy-MM-dd").format(date);
        }
        else
        {
            return "null";
        }
        
    }

    public static String formatToYYYYMMDDMMHHSS(Date date)
    {
    	YZYDateFormat format = YZYDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    
    public static Date formatToDayByYYYYMMDDMMHH(String s) throws ParseException {
    	YZYDateFormat format = YZYDateFormat.getInstance("yyyy-MM-dd HH:mm");
    	return format.parse(s);
    }
    
    public static String formatToYYYYMMDDMMHHSSSlash(Date date)
    {
    	YZYDateFormat format = YZYDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");
        return format.format(date);
    }
    
    public static String formatToYYYYMMDDSlash(Date date)
    {
    	YZYDateFormat format = YZYDateFormat.getInstance("yyyy/MM/dd");
        return format.format(date);
    }
    
    public static String formatToYMZSlash(Date date)
    {
    	YZYDateFormat format = YZYDateFormat.getInstance("yyyy年MM月dd日");
        return format.format(date);
    }

    /**
     * 返回一个二维数组，单位分别是月和日，代表两个Date之差。 <br>
     * 本方法忽略小时和分钟。 <br>
     * <br>
     * 例： <br>
     * 1，2012年6月1日到2012年6月3日，返回值是[0,2] （2天） <br>
     * 2，2012年6月15日到2012年8月4日，返回值是[1,20] （1个月零20天） <br>
     * 3，2011年11月3日到2013年1月14日，返回值是[14,11] （14个月零11天）
     * 
     * @param olderDate
     *            较早的日期
     * @param newerDate
     *            较晚的日期
     * @return
     * @throws IllegalPlatformAugumentException
     *             当olderDate晚于newerDate时
     */
    public static int[] getDateDifferenceInMonthAndDay(Date olderDate, Date newerDate)
            throws IllegalPlatformAugumentException
    {
        int[] differenceInMonthAndDay = new int[2];
        int years = 0;
        int months = 0;
        int days = 0;

        Calendar older = Calendar.getInstance();
		Calendar newer = Calendar.getInstance();
		older.setTime(olderDate);
		newer.setTime(newerDate);
		
        if(olderDate.getTime()>newerDate.getTime()){
        	throw new IllegalPlatformAugumentException();
        }else{
        	years = newer.get(Calendar.YEAR)-older.get(Calendar.YEAR);
        	if(years>=0){
        		
        		months = newer.get(Calendar.MONTH)-older.get(Calendar.MONTH)+12*years;
            	older.add(Calendar.MONTH,months);
            	days = newer.get(Calendar.DATE)-older.get(Calendar.DATE);
            	
            	if(days<0){
            		months = months - 1;
            		older.add(Calendar.MONTH,-1);
            	}
            	
            	days = daysBetween(newer.getTime(),older.getTime());
            	differenceInMonthAndDay[0] = months;
            	differenceInMonthAndDay[1] = days;
        	}
        	
        }  
        return differenceInMonthAndDay;
    }

    /**
     * 取两个Date之间的天数差<br>
     * <br>例：newerDate是6月3日，olderDate是5月31日，则应返回3
     * <br>一个更极端的列子：newerDate是6月3日 00:01，olderDate是6月2日 23:59，则应返回1，说明相差一天，即便实际上只差2分钟
     * <br>此代码来自网上
     * <br>http://blog.csdn.net/rmartin/article/details/1452867
     * @param newerDate
     * @param olderDate
     * @return
     */
    public static int daysBetween(Date newerDate, Date olderDate)
    {
        Calendar cNow = Calendar.getInstance();
        Calendar cReturnDate = Calendar.getInstance();
        cNow.setTime(newerDate);
        cReturnDate.setTime(olderDate);
        setTimeToMidnight(cNow);
        setTimeToMidnight(cReturnDate);
        long todayMs = cNow.getTimeInMillis();
        long returnMs = cReturnDate.getTimeInMillis();
        long intervalMs = todayMs - returnMs;
        return millisecondsToDays(intervalMs);
    }

    private static int millisecondsToDays(long intervalMs)
    {
        return (int) (intervalMs / (1000 * 86400));
    }

    private static void setTimeToMidnight(Calendar calendar)
    {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }
    /**
     * 得到距离当前时间前一个月的时间
     * @return
     * 
     */
    public static Date getLastMonthDate(){
    	Calendar lastMonthDate = Calendar.getInstance();
    	lastMonthDate.add(Calendar.MONTH, -1) ;
    	return lastMonthDate.getTime() ;
    }
}
