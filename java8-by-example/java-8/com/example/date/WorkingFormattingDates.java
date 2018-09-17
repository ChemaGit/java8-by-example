package com.example.date;

import static java.time.Month.FEBRUARY;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class WorkingFormattingDates {

	public static void main(String[] args) {
		String dateFormat = "MMMM d, yyyy";
		LocalDate aDate = null;
		LocalDate now = LocalDate.now();
		LocalDate abeBorn = LocalDate.of(1809, FEBRUARY, 12);
		//Create a formatter to accept date entries using the USA common standard(month day, year)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		//Use the parse method with the formatter to create a date. Add the following statement within the try block.
		aDate = LocalDate.parse(abeBorn.format(formatter), formatter);
		//To calculate the years, months, and days between now and the date entered, enter the following code
		Period between;
		if(aDate.isBefore(now)) {
			between = Period.between(aDate, now);
		} else {
			between = Period.between(now, aDate);
		}
		
		//Obtain the value of day, month and year and assign it to the variables: days, months, and years.
		int years = between.getYears();
		int months = between.getMonths();
		int days = between.getDays();
		//Print the values of the years, months, and days
		System.out.println("Date entered: " + abeBorn.format(formatter));
		System.out.println("Date now: " + now.format(formatter));
		System.out.println("There are " + years + " years, " + months + " months, " + days + " days between now and the date entered.");
	}

}
