package me.jinkun.rds.common.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/** yyyy-MM-dd HH:mm:ss **/
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** yyyy-MM-dd **/
	public static final String DAY_FORMAT = "yyyy-MM-dd";
	
	public static Date parseDate(String date) {
		return parse(date, DEFAULT_FORMAT);
	}

	public static Date parseDateByDay(String date) {
		return parse(date, DAY_FORMAT);
	}
	
	public static Date parse(String date, String format) {
		if(StringUtils.isEmpty(date)) {
			return null;
		}
		
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String get4Ymd(Date date) {
		return format(date, DEFAULT_FORMAT);
	}
	
	public static String getDay(Date date) {
		return format(date, DAY_FORMAT);
	}

	public static String format(Date date, String format) {
		if(date == null) {
			return null;
		}
		
		try {
			return new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Date addDay(Date date, int i) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(Calendar.DATE, i);
		return calendar.getTime();
	}
	
	public static Date addMinuter(Date date, int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(Calendar.MINUTE, i);
		return calendar.getTime();
	}

	public static Date addHour(Date date, int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, i);
		return calendar.getTime();
	}

	public static Date addSecond(Date date, int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, i);
		return calendar.getTime();
	}
	
	public static Date min(Date date, Date when) {
		return date.before(when)?date:when;
	}
	
}
