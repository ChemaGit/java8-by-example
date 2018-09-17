package com.example.date;
import static java.time.Month.DECEMBER;
import static java.time.temporal.ChronoUnit.*;
import java.time.LocalDate;
import java.time.Period;
public class CalculatingBetweenDaysExample {

	public static void main(String[] args) {
		LocalDate christmas = LocalDate.of(2017, DECEMBER, 25);
		LocalDate today = LocalDate.now();
		long days = DAYS.between(today, christmas);
		System.out.println("There are " + days + " shopping days til Christmas.");
		//Period also provides a between method
		Period tilXMax = Period.between(today, christmas);
		System.out.println("There are " + tilXMax.getMonths() +
				" months and " + tilXMax.getDays() +
				" days til Christmas.");
	}

}
