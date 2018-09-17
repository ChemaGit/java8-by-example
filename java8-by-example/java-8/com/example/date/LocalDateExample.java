package com.example.date;

import java.time.LocalDate;
import static java.time.DayOfWeek.*;

public class LocalDateExample {

	public static void main(String[] args) {
		//Que pasa maxo?
		LocalDate now, bDate, nowPlusMonth, nextTues;
		now = LocalDate.now();
		System.out.println("Now: " + now);
		
		bDate = LocalDate.of(1995, 5, 23); //Java's birthday
		System.out.println("Java's Bday: " + bDate);
		System.out.println("Is Java's Bday in the past? " + bDate.isBefore(now));
		System.out.println("Is Java's Bday in a leap year? " + bDate.isLeapYear());
		System.out.println("Java's Bday day of the week: " + bDate.getDayOfWeek());
		
		nowPlusMonth = now.plusMonths(1);
		System.out.println("The day a month from now is: " + nowPlusMonth);
		nextTues = now.with(java.time.temporal.TemporalAdjusters.next(TUESDAY));
		System.out.println("Next Tuesday's date: " + nextTues);
	}

}
