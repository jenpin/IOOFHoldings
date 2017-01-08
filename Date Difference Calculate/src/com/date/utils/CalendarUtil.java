package com.date.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Calendar Utility class to find the differences between the two dates.
 * 
 * @author Jennifer
 *
 */
public class CalendarUtil {

	/**
	 * Utility to find if a year is a leap year
	 * @param year
	 * @return Boolean to indicate if the year is a leap year
	 */
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * Utility to calculate the first leap year post a given reference year i.e 1900.
	 * @return The First leap year from 1900
	 */
	public int firstLeapYear() {
		int startYear = CalendarConstants.REFERENCEYEAR;
		for (int i = 0; i < 4; i++) {
			if (isLeapYear(startYear++)) {
				break;
			}
		}
		return startYear;
	}

	/**
	 * Utility to calculate the number of leap years between the first occurrence of a leap year 
	 * and the end year.
	 * @param endYear
	 * @return The Number of leap years in a duration.
	 */
	public int nbrOfLeapYears(int endYear) {
		int firstLeapYear = firstLeapYear();
		int count = (endYear - firstLeapYear) / 4;
		return count + 1;
	}

	/**
	 * Utility to calculate the number of days in the difference of the months.
	 * @param month
	 * @return the sum of  the number of days in the difference
	 */
	public int daysInMonth(int month) {
		int totalDays = 0;
		String key = "";
		for (int i = 1; i <= month; i++) {
			if (i < 10)
				key = "0" + i;
			else
				key = new Integer(i).toString();
			totalDays = totalDays + CalendarConstants.daysInAMonth.get(key);
		}
		return totalDays;
	}

	/**
	 * This method is the heart of the whole application.
	 * It checks for leap years as well as computes the difference between the inputs and
	 * 01-01-1900.
	 * @param day
	 * @param month
	 * @param year
	 * @return the difference between the 01-01-1900 and the input date.
	 */
	public int totalDays(int day, int month, int year) {
		int totalDiffYear = year - CalendarConstants.REFERENCEYEAR;
		int leapYearExtraDays = nbrOfLeapYears(year);
		int totalDaysofYear = totalDiffYear * CalendarConstants.DAYSINYEAR + leapYearExtraDays;
		return (day - 1) + daysInMonth(month - 1) + totalDaysofYear;
	}

	/**
	 * This method is used to calculate the greater date amongst the two. The logic is simply
	 * checking for greater number.
	 * e.g 14 09 2008  06 12 1908
	 * These two dates are converted to 20080914 and 19081206. The larger of the two numbers decides
	 * the end date.
	 * @param inputDateMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, String[]> orderDates(Map<String, String[]> inputDateMap) throws Exception {
		String date1 = null;
		String date2 = null;
		int i = 0;
		for (String[] value : inputDateMap.values()) {
			if (i == 0)
				date1 = value[2] + value[1] + value[0];
			if (i == 1)
				date2 = value[2] + value[1] + value[0];
			i++;
		}
		if(Integer.parseInt(date1) > Integer.parseInt(date2)){
			return sortMap(inputDateMap,true);
		}
		return sortMap(inputDateMap,false);
	}
	
	 /**
	  *Utility to sort a map based on a flag.
	 * @param inputMap
	 * @param flag
	 * @return
	 */
	Map<String, String[]> sortMap( Map<String, String[]> inputMap,boolean flag){
		Map<String, String[]> sortedDateMap = new LinkedHashMap<String, String[]>();
		
		Set<Entry<String, String[]>> mapValues = inputMap.entrySet();
		int maplength = mapValues.size();
		Entry<String, String[]>[] test = new Entry[maplength];
		mapValues.toArray(test);
		if (flag) {
			sortedDateMap.put(test[maplength - 1].getKey(), test[maplength - 1].getValue());
			sortedDateMap.put(test[0].getKey(), test[0].getValue());
		} else {
			sortedDateMap.put(test[0].getKey(), test[0].getValue());
			sortedDateMap.put(test[maplength - 1].getKey(), test[maplength - 1].getValue());
		}
		return sortedDateMap;
	}
}
