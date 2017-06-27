package com.gapinc.booking.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String... pattern) {
		DateFormat df;
		if (pattern.length > 0)
			df = new SimpleDateFormat(pattern[0]);
		else
			df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

}
