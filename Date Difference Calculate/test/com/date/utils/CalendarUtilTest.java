package com.date.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.date.utils.CalendarUtil;

public class CalendarUtilTest {

	private CalendarUtil calendarUtil;

	@Before
	public void setUp() throws Exception {
		calendarUtil = new CalendarUtil();
	}

	/**
	 * Positive Scenario : Calculate the number of leap years
	 * 
	 * @throws Exception
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


	//@Test
	public void testNbrOfLeapYears() {

	}

}
