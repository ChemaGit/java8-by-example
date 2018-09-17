package com.example.date;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.time.Month.*;

public class PeriodExample {

	public static void main(String[] args) {
		Period oneDay = Period.ofDays(1);
		System.out.println("Period of one day: " + oneDay);
		LocalDateTime beforeDST = LocalDateTime.of(2017, JUNE, 5, 12, 00);
		ZonedDateTime newYorkTime = ZonedDateTime.of(beforeDST, ZoneId.of("America/New_York"));
		System.out.println("Before: " + newYorkTime);
		System.out.println("After: " + newYorkTime.plus(oneDay));

	}

}
