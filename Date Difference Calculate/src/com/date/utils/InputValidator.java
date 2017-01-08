package com.date.utils;

/**
 * The class is a Validator class to perform validations on the input
 * - It validates the Day Month Year format
 * - Check for valid days in the months
 * - Checks for only numeric characters
 * - Verifys the format of the input
 * @author Jennifer
 *
 */
public class InputValidator {
	
	public void checkValidValues(String[] dateString) throws Exception{
		int day=Integer.parseInt(dateString[0]);
		int month = Integer.parseInt(dateString[1]);
		if(day==00 || month==00 || (day>CalendarConstants.daysInAMonth.get(dateString[1])))
		throw new Exception ("Your days are not valid for the associated month. ");
	}
	
	public void checkLength(String[] dateString) throws Exception{
		if(dateString.length!=3)
		throw new Exception ("Your input date should a valid day ,a valid month and a valid year ");
	}
	
	public void checkNumber(String[] dateString) throws Exception{
		for(String i :dateString){
			if(!i.matches("\\d*"))
				throw new Exception ("Your input date should hold only numbers ");
		}
	}
	
	public void checkNumberFormat(String[] dateString) throws Exception{
		if (!(dateString[0].length()==2 && dateString[1].length()==2 && dateString[2].length()==4)){
		 throw new Exception ("The date format has to be DD MM YYYY. ");
		}
	}
	
	public void checkDateRange(String[] dateString) throws Exception{
		if(!(Integer.parseInt(dateString[2])>=1900 && Integer.parseInt(dateString[2])<=2010))
		throw new Exception ("Your input date should be between 1990 and 2010. ");
	}
	
	
	public void validateDates(String [] dateToken) throws Exception{
		checkNumber(dateToken);
		checkNumberFormat(dateToken);
		checkValidValues(dateToken);
		checkLength(dateToken);
		checkDateRange(dateToken);
	}
	
}
