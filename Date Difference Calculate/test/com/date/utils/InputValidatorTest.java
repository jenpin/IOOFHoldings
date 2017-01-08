package com.date.utils;

import org.junit.Before;
import org.junit.Test;

public class InputValidatorTest {

	private InputValidator inputValidator;

	@Before
	public void setUp() throws Exception {
		inputValidator = new InputValidator();
		CalendarConstants.initDaysInAMonth();
	}

	/**
	 * Positive Scenario : Check for the format of input DD MM YYYY
	 */
	@Test
	public void testCheckFormatPositive() throws Exception{
		String expectedsArray[] =  new String[] { "01","12","2010"};
		inputValidator.checkValidValues(expectedsArray);
	}
	
	/**
	 * Negative Scenario : Invalid days in the associated month
	 */
	@Test(expected=Exception.class)
	public void testCheckFormatNegative()throws Exception{
		String expectedsArray[] =  new String[] { "32","12","2010"};
		inputValidator.checkValidValues(expectedsArray);
	}

	/**
	 * Positive Scenario : Check for three inputs
	 */
	@Test
	public void testcheckLengthPositive()throws Exception{
		String expectedsArray[] = new String[] { "1","12","2010"};
		inputValidator.checkLength(expectedsArray);
	}
	
	/**
	 * Negative Scenario : Check for a non zero month
	 */
	@Test(expected=Exception.class)
	public void testcheckValidValuesNegative3()throws Exception{
		String expectedsArray[] = new String[] {"01","00","2010"};
		inputValidator.checkValidValues(expectedsArray);
	}
	
	/**
	 * Negative Scenario : Check if day,month and year is present
	 */
	@Test(expected=Exception.class)
	public void testCheckLengthNegative()throws Exception{
		String expectedsArray[] = new String[] {"00","12","2010",""};
		inputValidator.checkLength(expectedsArray);
	}
	

	/**
	 * Negative Scenario : Check for only numbers in date
	 */
	@Test(expected=Exception.class)
	public void testCheckNumberNegative()throws Exception{
		String expectedsArray[] = new String[] {"a","12","2010"};
		inputValidator.checkNumber(expectedsArray);
	}
	
	/**
	 * Negative Scenario : Check for empty fields
	 */
	@Test(expected=Exception.class)
	public void testCheckNumberNegative2()throws Exception{
		String expectedsArray[] = new String[] {"1"," ","2010"};
		inputValidator.checkNumber(expectedsArray);
	}
	
	/**
	 * Negative Scenario : Check for valid number format
	 */
	@Test(expected=Exception.class)
	public void testCheckNumberFormatNegative()throws Exception{
		String expectedsArray[] = new String[] {"1","12","2010"};
		inputValidator.checkNumberFormat(expectedsArray);
	}
	
	/**
	 * Negative Scenario : Check for valid number format
	 */
	@Test(expected=Exception.class)
	public void testCheckNumberFormatNegative2()throws Exception{
		String expectedsArray[] = new String[] {"19","8","2010"};
		inputValidator.checkNumberFormat(expectedsArray);
	}
	
	
	/**
	 * Negative Scenario : Check for valid number format
	 */
	@Test(expected=Exception.class)
	public void testCheckDateRangeNegative()throws Exception{
		String expectedsArray[] = new String[] {"1","12","2020"};
		inputValidator.checkDateRange(expectedsArray);
	}

}
