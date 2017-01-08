package com.date.entrypoint;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.date.utils.CalendarConstants;
import com.date.utils.CalendarUtil;
import com.date.utils.InputValidator;

public class DateDifferenceCalculator {

	public CalendarUtil calendarUtil = new CalendarUtil();
	public InputValidator validator = new InputValidator();

	/**
	 * This method calculates the difference between 01-JAN-1900 and the input dates
	 * and then using that as a benchmark calculates the difference between the start and end dates.
	 * @param inputDateMap
	 * @return List of the Start Date,End Date and difference
	 */
	public List<String> calculateDifference(Map<String, String[]> inputDateMap) {
		List<String> outputList = new ArrayList<String>();
		List<Integer> count = new ArrayList<Integer>();

		for (Map.Entry<String, String[]> entry : inputDateMap.entrySet()) {
			outputList.add(entry.getKey());
			String[] token = entry.getValue();
			count.add(calendarUtil.totalDays(Integer.parseInt(token[0]), Integer.parseInt(token[1]),Integer.parseInt(token[2])));
		}
		System.out.println("Start date diffe :"+ count.get(0) +"End date difference:"+ count.get(1));
		int diff = count.get(1) - count.get(0);
		outputList.add(String.valueOf(diff));
		return outputList;
	}

	/**
	 * Entry point of the application
	 * @param args
	 * 1. File path of the csv that holds the dates
	 */
	public static void main(String[] args) {

		try {
			DateDifferenceCalculator calculate = new DateDifferenceCalculator();
			CalendarConstants.initDaysInAMonth();
			String[] dateList = null;
			
			if (args.length == 1) {
				dateList = calculate.readFile(args[0]);
			} else{
			dateList = calculate.readFile(null);
			}
			Map<String, String[]> inputDateMap = calculate.validateOrderInputs(dateList);
			List<String> output = calculate.calculateDifference(inputDateMap);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * Invokes the validator to validate the inputs .The following checks are performed.
	 * - Format of date
	 * - Number of dates provided in the input
	 * - Year Range to be between 1900 and 2010.
	 * - Sart Date and End Date cannot be the same.
	 * @param dateList - Read from the input file
	 * @return LinkedHashMap holding the valid and ordered dates.
  	 * @throws Exception
	 */
	public Map<String, String[]> validateOrderInputs(String[] dateList) throws Exception {
		Map<String, String[]> inputDateMap = new LinkedHashMap<String, String[]>();
		if (dateList.length == 2) {
			for (int i = 0; i < dateList.length; i++) {
				if(!dateList[i].matches(".*\\s.*")){
					throw new Exception("Expected date format is DD MM YYYY.");
				}
				inputDateMap.put(dateList[i], dateList[i].split("\\s+"));
				validator.validateDates(inputDateMap.get(dateList[i]));
			}
		} else {
			throw new Exception("Only two different dates are expected as inputs!");
		}
		inputDateMap = calendarUtil.orderDates(inputDateMap);
		return inputDateMap;
	}

	/**
	 * Reads the CSV to create a List of Dates
	 * 
	 * @param csvFile
	 * @return List of Dates in the file
	 * @throws Exception
	 */
	public String[] readFile(String csvFile) throws Exception {

		if (null == csvFile) {
			csvFile = "src/resource/input/inputFile.csv";
		}
		String[] dateInputs;
		try {
			List<String> lines = Files.readAllLines(Paths.get(csvFile), StandardCharsets.UTF_8);
			if (lines.size() == 0 || lines.size() > 1) {
				throw new Exception("File is empty or has more than a line.");
			}
			dateInputs = lines.get(0).split(CalendarConstants.COMMA);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Issue in the File :" + e.getMessage());
		}
		return dateInputs;
	}
}
