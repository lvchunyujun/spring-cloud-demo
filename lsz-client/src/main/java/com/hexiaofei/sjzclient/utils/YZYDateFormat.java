package com.hexiaofei.sjzclient.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * 日期格式器 <br/>
 * 该格式器不是线程安全的，在每个线程中使用DateFormat时都应该使用DateFormat的相关getInstance方法获取。<br/>
 * 
 * 试图将当前线程中获取的DateFormat实例传给另一个线程使用，可能会出现并发问题。
 * <p>
 * 
 * 例如：
 * 
 * <pre>
 * Date date = DateFormat.getInstance(&quot;yyyy-MM-dd HH.mm.ss&quot;).parse(&quot;2011-06-22 19.49.28&quot;);
 * String str = DateFormat.getInstance(&quot;yyyy-MM-dd HH.mm.ss&quot;).format(date);
 * </pre>
 * 
 * 
 * @since v1.1
 * @history
 * @see
 */
public class YZYDateFormat
{

	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH.mm.ss";

	/**
	 * 内置的日期格式器
	 */
	private SimpleDateFormat dateFormat;

	/**
	 * 语言环境
	 */
	private Locale locale;

	/**
	 * 用来在线程内缓存日期格式器
	 */
	private static ThreadLocal<Map<Key, YZYDateFormat>> formatMapThreadLocal = new ThreadLocal<Map<Key, YZYDateFormat>>();

	/**
	 * 
	 * 构造函数，设成了私有来强制用户使用DateFormat.getXXInstance()等方法获取格式器
	 * 
	 * @param dateFormat
	 * @param locale
	 * 
	 */
	private YZYDateFormat(SimpleDateFormat dateFormat, Locale locale)
	{
		this.dateFormat = dateFormat;
		this.locale = locale;
	}

	/**
	 * 获取格式器实例,该格式器的格式采用"yyyy-MM-dd HH.mm.ss", 时区、语言环境从服务器的当前环境中获取。
	 * 
	 * @return
	 * 
	 */
	public static YZYDateFormat getInstance()
	{
		return getInstance(DEFAULT_FORMAT);
	}

	/**
	 * 
	 * 获取格式器实例
	 * 
	 * @param pattern
	 *            模式
	 * @param timeZone
	 *            时区
	 * @param locale
	 *            语言环境
	 * @return 格式器
	 * 
	 */
	public static YZYDateFormat getInstance(String pattern, TimeZone timeZone, Locale locale)
	{
		Map<Key, YZYDateFormat> formatMap = formatMapThreadLocal.get();
		if (formatMap == null)
		{
			formatMap = new HashMap<Key, YZYDateFormat>();
			formatMapThreadLocal.set(formatMap);
		}

		Key key = new Key(pattern, locale);

		YZYDateFormat format = formatMap.get(key);
		if (format == null)
		{
			format = new YZYDateFormat(new SimpleDateFormat(pattern, locale), locale);
			formatMap.put(key, format);
		}
		format.setTimeZone(timeZone);
		return format;
	}

	/**
	 * 
	 * 获取格式器实例,该格式器的时区、语言环境从服务器的当前环境中获取。
	 * 
	 * @param pattern
	 *            模式
	 * @return
	 * 
	 */
	public static YZYDateFormat getInstance(String pattern)
	{
		return getInstance(pattern, TimeZone.getDefault(), Locale.getDefault());
	}

	/**
	 * 
	 * 将java.util.Date对象格式化成String
	 * 
	 * @param date
	 *            日期
	 * @return 字符串
	 * 
	 */
	public String format(Date date)
	{
		return dateFormat.format(date);
	}

	/**
	 * 
	 * 将long型（从标准基准时间即 1970 年 1 月 1 日 00:00:00 GMT以来的指定毫秒数）格式化成String<br/>
	 * 
	 * @param date
	 *            从标准基准时间即 1970 年 1 月 1 日 00:00:00 GMT以来的指定毫秒数
	 * @return 字符串
	 * 
	 */
	public String format(long date)
	{
		return dateFormat.format(new Date(date));
	}

	/**
	 * 
	 * 将时间串解析成java.util.Date,解析失败将抛出RuntimeException
	 * 
	 * @param source
	 *            时间串
	 * @return
	 * 
	 */
	public Date parse(String source) throws ParseException
	{
		return dateFormat.parse(source);
	}

	/**
	 * 
	 * 将时间串解析成距离标准时间的毫秒数,解析失败将抛出RuntimeException
	 * 
	 * @param source
	 *            时间串
	 * @return
	 * 
	 */
	public long parseToLong(String source) throws ParseException
	{
		return parse(source).getTime();
	}

	/**
	 * 
	 * 获取格式器的格式
	 * 
	 * @return 格式
	 * 
	 */
	public String getPattern()
	{
		return dateFormat.toPattern();
	}

	/**
	 * 
	 * 获取时区
	 * 
	 * @return
	 * 
	 */
	public TimeZone getTimeZone()
	{
		return dateFormat.getTimeZone();
	}

	/**
	 * 
	 * 设置时区
	 * 
	 * @param zone
	 * 
	 */
	public void setTimeZone(TimeZone zone)
	{
		dateFormat.setTimeZone(zone);
	}

	/**
	 * 
	 * 获取格式器内部的语言环境
	 * 
	 * @return
	 * 
	 */
	public Locale getLocale()
	{
		return this.locale;
	}

	/**
	 * 用来标示一个Format
	 * 
	 * 
	 * @since v1.0
	 * @history
	 * @see
	 */
	private static class Key
	{
		String pattern;

		Locale locale;

		Key(String pattern, Locale locale)
		{
			this.pattern = pattern;
			this.locale = locale;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((locale == null) ? 0 : locale.hashCode());
			result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (locale == null)
			{
				if (other.locale != null)
					return false;
			}
			else if (!locale.equals(other.locale))
				return false;
			if (pattern == null)
			{
				if (other.pattern != null)
					return false;
			}
			else if (!pattern.equals(other.pattern))
				return false;
			return true;
		}
	}

	public static void main(String[] args)
	{

		
		
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy-MM-dd HH.mm.ss");
		String ds = format.format(getMonday(new Date()));
		
		System.out.println(ds);

		
		
		/*Date startInterestTime = new Date();
		int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		if(day==1||day==6||day==7){
			startInterestTime = YZYDateFormat.getMonday(new Date());
		}else{
			Calendar today = Calendar.getInstance();
			today.setTime(startInterestTime);
			today.add(Calendar.DAY_OF_MONTH, 1);
			startInterestTime = today.getTime();
		}*/
		System.out.println(ds);
		// SimpleDateFormat format = new
		// SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SZ");

		// String dateStr = "2010-10-13-09.17.07.099+480";
		// try {
		// Date date = format.parse(dateStr);
		// System.out.println(date.getTime());
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// Date date = new Date();
		// System.out.println(format.format(date));
		// // format.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		// System.out.println(format.format(date));
	}
	
	/**
	 * 获取下周一日期
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date getMonday(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        
        if(week>2){
        	// 周一 ~ 周六
            cal.add(Calendar.DAY_OF_MONTH,9-week);
        }else{
        	// 周日
            cal.add(Calendar.DAY_OF_MONTH,1);
        }
        return cal.getTime();
    }

}
