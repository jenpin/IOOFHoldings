package com.date.utils;

import java.util.HashMap;

public class CalendarConstants {
	
	public static HashMap<String,Integer> daysInAMonth= new HashMap<String,Integer>();
	public static void initDaysInAMonth(){
		daysInAMonth.put("01", 31);
		daysInAMonth.put("02", 28);
		daysInAMonth.put("03", 31);
		daysInAMonth.put("04", 30);
		daysInAMonth.put("05", 31);
		daysInAMonth.put("06", 30);
		daysInAMonth.put("07", 31);
		daysInAMonth.put("08", 31);
		daysInAMonth.put("09", 30);
		daysInAMonth.put("10", 31);
		daysInAMonth.put("11", 30);
		daysInAMonth.put("12", 31);
	}
	
	public static final int DAYSINYEAR = 365;
	
	public static final int REFERENCEMONTH = 1;
	
	public static final int REFERENCEDAY = 1;
	
	public static final int REFERENCEYEAR = 1900;
	
	public static final int FIRSTLEAPYEAR = 1904;
	
	public static final String COMMA = ",";
	
}
