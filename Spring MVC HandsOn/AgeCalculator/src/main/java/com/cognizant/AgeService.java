package com.cognizant;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeService {

	
	public  String calculateAge (String date){
	
	//add the code as per the requirement
	LocalDate dob = LocalDate.parse(date); // specify year, month, date directly
	LocalDate now = LocalDate.now(); // gets localDate
	Period diff = Period.between(dob, now); // difference between the dates is 
	String result = "you are "+diff.getYears() + " years, " + diff.getMonths() + " months, " + diff.getDays() + " days old.";
		
		return result;
}
}
