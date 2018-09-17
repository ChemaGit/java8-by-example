package com.example.date;

import java.time.*;
import static java.time.temporal.ChronoUnit.*;
import static java.time.Month.*;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		//What's up, man?
		LocalDateTime meeting, flight, courseStart, courseEnd;
		meeting = LocalDateTime.of(2017, JUNE, 7, 12, 30);
		System.out.println("Meeting is on: " + meeting);
		LocalDate flightDate = LocalDate.of(2017, JULY, 14);
		LocalTime flightTime = LocalTime.of(4, 30);
		flight = LocalDateTime.of(flightDate, flightTime);
		System.out.println("Flight leaves: " + flight);
		courseStart = LocalDateTime.of(2017, OCTOBER, 30, 16, 00);
		courseEnd = courseStart.plusDays(65).plusHours(5);
		System.out.println("Course starts: " + courseStart);
		System.out.println("Course ends: " + courseEnd);
		long courseHrs = (courseEnd.getHour() - courseStart.getHour()) *
						 (courseStart.until(courseEnd, DAYS) + 1);
		System.out.println("Course is: " + courseHrs + " hours long");
	}

}
