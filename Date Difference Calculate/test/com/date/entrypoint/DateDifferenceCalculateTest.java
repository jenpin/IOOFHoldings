package com.date.entrypoint;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.date.utils.CalendarConstants;

public class DateDifferenceCalculateTest {
	private DateDifferenceCalculator differenceCalc;

	@Before
	public void setUp() throws Exception {
		differenceCalc = new DateDifferenceCalculator();
		CalendarConstants.initDaysInAMonth();
	}

	/**
	 * Postive Scenario : To check if file is read correctly
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReadFile() throws Exception {
		String expectedsArray[] = { "22 03 2010", "13 07 1906" };
		String[] dateArray = differenceCalc.readFile("test/resource/input/validInputs.csv");
		assertArrayEquals(expectedsArray, dateArray);
	}

	/**
	 * Negative Scenario : An invalid file is trying is inputed.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testReadInvalidFile() throws Exception {
		String[] dateArray = differenceCalc.readFile("test/resource/input/invalidInputs.csv");
		Map<String, String[]> dateMap = differenceCalc.validateOrderInputs(dateArray);
	}

	/**
	 * Negative Scenario : A blank file is set as input.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testReadBlankFile() throws Exception {
		String[] dateArray = differenceCalc.readFile("test/resource/input/blankFile.csv");
		Map<String, String[]> dateMap = differenceCalc.validateOrderInputs(dateArray);
	}

	/**
	 * Positive Scenario : To validate and order the dates inputed
	 * 
	 * @throws Exception
	 */
	@Test
	public void testvalidateOrderInputs() throws Exception {
		String expectedsArray[] = { "22 03 2010", "13 07 1906" };
		List<String> outputs = new ArrayList<String>();
		Map<String, String[]> dateMap = differenceCalc.validateOrderInputs(expectedsArray);
		for (Map.Entry<String, String[]> entry : dateMap.entrySet()) {
			outputs.add(entry.getKey());
		}
		assertEquals("13 07 1906", outputs.get(0));
	}

	/**
	 * Negative Scenario : To validate and order the dates inputed
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testvalidateOrderInputsNegative() throws Exception {
		String expectedsArray[] = { "22-03/2010", "13-07-1906" };
		Map<String, String[]> dateMap = differenceCalc.validateOrderInputs(expectedsArray);
	}

	/**
	 * Positive Scenario : To validate and order the dates inputed
	 * 
	 * @throws Exception
	 */
	@Test
	public void testvalidateOrderInputsNegative2() throws Exception {
		String expectedsArray[] = { "22 03 2010", "13 07 1906" };
		Map<String, String[]> dateMap = differenceCalc.validateOrderInputs(expectedsArray);
	}

	/**
	 * Negative Scenario : To validate and order the dates inputed
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testvalidateOrderInputNegative() throws Exception {
		String expectedsArray[] = { "22-03-2010", "22-03-2010" };
		Map<String, String[]> dateMap = differenceCalc.validateOrderInputs(expectedsArray);

	}

}
