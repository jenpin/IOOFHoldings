package com.date.utils;

public class CalendarUtil {

	// create an map for month and the days
	// create a method to calculate the nbr of leap years given a range of year
	// create util to find the daysInterval between 01-01-1900 and current date

	public boolean isLeapYear(int year){
		if(year % 4==0 && (year % 100!=0 || year % 400==0)){
			return true;
		}
		return false;
	}

	public int nbrOfLeapYears(int endYear){
		int count = 0;
		count = (endYear - CalendarConstants.firstLeapYear)/ 4 ;
		return count+1;
	}
}
