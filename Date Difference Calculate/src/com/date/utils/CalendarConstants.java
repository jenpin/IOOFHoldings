package com.date.utils;

import java.util.HashMap;

public class CalendarConstants {
	
	public static HashMap<Integer,Integer> daysInAMonth = new HashMap<Integer,Integer>();
	static void initDaysInAMonth(){
		daysInAMonth.put(1, 31);
		daysInAMonth.put(2, 28);
		daysInAMonth.put(3, 31);
		daysInAMonth.put(4, 30);
		daysInAMonth.put(5, 31);
		daysInAMonth.put(6, 30);
		daysInAMonth.put(7, 31);
		daysInAMonth.put(8, 31);
		daysInAMonth.put(9, 30);
		daysInAMonth.put(10, 31);
		daysInAMonth.put(11, 30);
		daysInAMonth.put(12, 31);
	}
	
	public static final String referenceDate = "01-01-1900";
	
	public static final int firstLeapYear=1904;
	
}
