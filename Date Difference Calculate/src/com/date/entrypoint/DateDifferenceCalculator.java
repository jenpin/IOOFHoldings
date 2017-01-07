package com.date.entrypoint;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DateDifferenceCalculator {

	public static void main(String[] args) {
		
		try{
			DateDifferenceCalculator calculate = new DateDifferenceCalculator();
			//read the twodates from the file
			String [] dateList = calculate.readFile(args[0]);
			//validate the dates
			
			//find the greater date
			//calculate the difference between 01-01-1900 and start date
			//calculate the difference between 01-01-1900 and end date
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

	}

	
	/**
	 * Reads the CSV to create a List of Dates
	 * @param csvFile
	 * @return List of Events in the file
	 * @throws Exception
	 */
	public String[] readFile(String csvFile) throws Exception {

		if (null == csvFile) {
			csvFile = "resource\\input\\inputFile.csv";
		}
		String[] dateInputs;
		try {
			List<String> lines = Files.readAllLines(Paths.get(csvFile), StandardCharsets.UTF_8);
			if (lines.size() == 0 || lines.size() > 1) {
				throw new Exception("File is empty or has more than a line.");
			} 
			dateInputs=lines.get(0).split("\\s+");
			
		} catch (Exception e) {
			throw new Exception("Issue in the File :" + e.getMessage());
		}
		return dateInputs;
	}
}
