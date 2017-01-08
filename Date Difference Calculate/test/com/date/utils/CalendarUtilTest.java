package com.date.utils;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.date.utils.CalendarUtil;

public class CalendarUtilTest {

	private CalendarUtil calendarUtil;

	@Before
	public void setUp() throws Exception {
		calendarUtil = new CalendarUtil();
		CalendarConstants.initDaysInAMonth();
	}

	/**
	 * Positive Scenario : Calculate the number of leap years
	 */
	@Test
	public void testNbrOfLeapYearsPositive(){
		int leapYears = calendarUtil.nbrOfLeapYears(2007);
		assertEquals(26, leapYears);
	}
	
	/**
	 * Positive Scenario : Calculate the number of leap years for a leap year
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNbrOfLeapYearsPositive2(){
		int leapYears = calendarUtil.nbrOfLeapYears(1984);
		assertEquals(21, leapYears);
	}


	/**
	 * Positive Scenario : Valid scenarios for non leap year 
	 */
	@Test
	public void testTotalDaysofYear() { 
	  int totalDays = calendarUtil.totalDays(3, 4, 1987);
	  assertEquals(31868,totalDays);
	}
	
	/**
	 * Positive Scenario : Valid scenarios for leap year 
	 */
	@Test
	public void testTotalDaysofLeapYear() { 
	  int totalDays = calendarUtil.totalDays(29, 11, 1904);
	  assertEquals(1793,totalDays);
	}
	
	/**
	 * Positive Scenario : Valid scenarios for leap year 
	 */
	@Test
	public void testTotalDaysofNonYear() { 
	  int totalDays = calendarUtil.totalDays(10, 10, 1968);
	  assertEquals(25119,totalDays);
	}
	
	/**
	 * Positive Scenario : Arrange start and end dates 
	 */
	@Test
	public void testOrderDates() throws Exception { 
	  Map<String,String[]> inputDateMap = new HashMap<String,String[]>();
	  ArrayList<String> keyArray = new ArrayList<>();
	  inputDateMap.put("11 03 1976",new String[]{"11","03","1976"});
	  inputDateMap.put("28 01 1980",new String[]{"28","01","1980"});
	  
	  Map<String,String[]> orderedDateMap = calendarUtil.orderDates(inputDateMap);
	  for (Map.Entry<String, String []> entry : orderedDateMap.entrySet()) {
		  keyArray.add(entry.getKey());
		}
	  assertEquals("11 03 1976",keyArray.get(0));
	}

	/**
	 * Negative Scenario : Both start and end dates are same
	 */
	@Test(expected=Exception.class)
	public void testOrderDatesSameDates() throws Exception { 
	  Map<String,String[]> inputDateMap = new LinkedHashMap<String,String[]>();
	  inputDateMap.put("11 03 1976",new String[]{"11","03","1976"});
	  inputDateMap.put("11 03 1976",new String[]{"11","03","1976"});
	  Map<String,String[]> orderedDateMap = calendarUtil.orderDates(inputDateMap);
	}
	
	/**
	 * Positive Scenario : Variation in start and end dates 
	 */
	@Test
	public void testOrderDatesVariation() throws Exception { 
	  Map<String,String[]> inputDateMap = new LinkedHashMap<String,String[]>();
	  ArrayList<String> keyArray = new ArrayList<>();
	  inputDateMap.put("11 03 1989",new String[]{"11","03","1989"});
	  inputDateMap.put("11 03 1907",new String[]{"11","03","1907"});
	  Map<String,String[]> orderedDateMap = calendarUtil.orderDates(inputDateMap);
	  for (Map.Entry<String, String []> entry : orderedDateMap.entrySet()) {
		     keyArray.add(entry.getKey());
		}
	  assertEquals("11 03 1907",keyArray.get(0));
	}
	
	/**
	 * Positive Scenario : Variation in start and end dates 
	 */
	@Test
	public void testSortMap() throws Exception { 
	  Map<String,String[]> inputDateMap = new LinkedHashMap<String,String[]>();
	  ArrayList<String> keyArray = new ArrayList<>();
	  inputDateMap.put("31 03 1989",new String[]{"31","03","1989"});
	  inputDateMap.put("02 03 1907",new String[]{"02","03","1907"});
	  Map<String,String[]> orderedDateMap = calendarUtil.sortMap(inputDateMap,true);
	  for (Map.Entry<String, String []> entry : orderedDateMap.entrySet()) {
		     keyArray.add(entry.getKey());
		}
	  assertEquals("02 03 1907",keyArray.get(0));
	}
	/**
	 * Positive Scenario : Sort Map method test
	 */
	@Test
	public void testSortMapVariation() throws Exception { 
	  Map<String,String[]> inputDateMap = new LinkedHashMap<String,String[]>();
	  ArrayList<String> keyArray = new ArrayList<>();
	  inputDateMap.put("31 03 1960",new String[]{"31","03","1960"});
	  inputDateMap.put("02 03 1907",new String[]{"02","03","1907"});
	  Map<String,String[]> orderedDateMap = calendarUtil.sortMap(inputDateMap,false);
	  for (Map.Entry<String, String []> entry : orderedDateMap.entrySet()) {
		     keyArray.add(entry.getKey());
		}
	  assertEquals("02 03 1907",keyArray.get(0));
	}
}
