package com.tieba.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * 时间工具类
 * 
 * @author Administrator
 * 
 */
public class DateKit {
	//private static Log log = LogFactory.getLog(DateUtils.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	private static Calendar cal = Calendar.getInstance();

	/**
	 * 获得秒数时间戳
	 * 
	 * @return
	 */
	public static int getTimeStamp() {
		long longTime = System.currentTimeMillis();
		return (int) (longTime / 1000);
	}

	public static int getTimeStampByDate(Date date) {
		long longTime = date.getTime();
		return (int) (longTime / 1000);
	}

	/**
	 * 将秒数时间戳 还原成日期对象
	 * 
	 * @param timestamp
	 *            秒数时间戳
	 * @return
	 */
	public static Date formatTimeStamp(int timestamp) {
		long longTime = toLong(timestamp);
		return new Date(longTime);
	}

	private static long toLong(int timestamp) {
		return (long) timestamp * 1000;
	}

	/**
	 * 格式化日期对象
	 * 
	 * @param date
	 *            对象
	 * @param pattern
	 *            格式
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}

	/**
	 * 格式化字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String date, String pattern) {
		Date result = null;
		sdf.applyPattern(pattern);
		try {
			result = sdf.parse(date);
		} catch (ParseException e) {
			/*log.error("格式化date出错, " + e);*/
		}
		return result;
	}

	/**
	 * 返回指定日期年份
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 返回指定日期月份
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * 返回指定日期月份中的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayInMonth(Date date) {
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 字符串转换到时间格式
	 * 
	 * @param dateStr
	 *            需要转换的字符串
	 * @param formatStr
	 *            需要格式的目标字符串 举例 yyyy-MM-dd
	 * @return Date 返回转换后的时间
	 * @throws ParseException
	 *             转换异常 例子：Date d1 =
	 *             DateUtils.StringToDate("2012-09-27 14:33:45",
	 *             "yyyy-MM-dd HH:mm:ss");
	 */
	public static Date StringToDate(String dateStr, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// ********************************************************************************************************
	/**
	 *  功能：两个日期之间相差的分钟数
	 *  @param beginDate 被比较的值
	 *  @param endDate   比较的值 
	 * 	@return int
 	 *	@throws ParseException
 	 *  例子: 我要比较  Thu Sep 27 14:33:45 CST 2012 和  Thu Sep 27 15:13:41 CST 2012 之间相差多少分钟
 	 *  那么   Thu Sep 27 14:33:45 CST 2012 他就是beginDate
 	 *       Thu Sep 27 15:13:41 CST 2012他就是endDate
	 */
	public static int getMinuteDiff(Date beginDate, Date endDate){
		int i1 = getTimeStampByDate(beginDate);
		int i2 = getTimeStampByDate(endDate);
		int i3 = i2 - i1;
		int i4 = i3/60;
		return i4;
	}
	
	/**
	 *  功能：截取两个日期之间的天数
	 *  @param String beginDate,String endDate
	 * 	@return int
 	 *	@throws ParseException
	 */
	public static int getDay(String beginDate, String endDate)
			throws ParseException {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sim.parse(beginDate);
		Date d2 = sim.parse(endDate);
		return (int) ((d2.getTime() - d1.getTime()) / (3600L * 1000 * 24));
	}
	/**
	 *  描述:一个日期加上一个天数，得到一个新的日期* @param String beginDate, long addDay
	 *   @return Date
	 *   @throws ParseException
	 */

	public static Date getNewDate(String beginDate, long addDay)
			throws ParseException {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sim.parse(beginDate.trim());
		long time = d1.getTime();
		addDay = addDay * 24 * 60 * 60 * 1000;
		time += addDay;
		return new Date(time);
	}
	/**
	 *  功能：一个日期时间加上分钟数，得到一个新的日期时间* @param String beginDate, long addDay
	 *  @return Date
	 *  @throws ParseException
	 *  @throws ParseException
	 */

	public static Date getNewDateTime(String beginDateTime, long addMinutes)
			throws ParseException {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d1 = sim.parse(beginDateTime);
		long time = d1.getTime();
		addMinutes = addMinutes * 60 * 1000;
		time += addMinutes;
		return new Date(time);

	}
	/**
	 * 获取现在时间，年月日
	 * @return
	 */
	public static Date getDateShort() {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   String dateString = formatter.format(currentTime);
	   Date date = DateKit.StringToDate(dateString, "yyyy-MM-dd");
	   return date;
	}
	/**
	 * 根据时区 获取当前时间（Asia/Shanghai）
	 * @param _timeZone
	 * @return
	 */
	public static Date realTime(String _timeZone){
	     TimeZone timeZone = null;
	     if(StrKit.isBlank(_timeZone)){
	         timeZone = TimeZone.getDefault();
	     }else{
	         timeZone = TimeZone.getTimeZone(_timeZone);
	     }
	   
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
	     sdf.setTimeZone(timeZone);
	     return StringToDate(sdf.format(new Date()),"yyyy年MM月dd日  HH时mm分ss秒");
	}
}
