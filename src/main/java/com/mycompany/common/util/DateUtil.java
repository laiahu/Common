package com.mycompany.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {

	private static Log log = LogFactory.getLog(DateUtil.class);
	
	public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";
	
	public static String date2String(Date date,String pattern){
		String result = "";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			result = sdf.format(date);
		}catch(Exception e){
			log.info("date=["+date+"] to pattern=["+pattern+"] error,msg=["+e.getMessage()+"]");
		}
		return result;
	}
}
