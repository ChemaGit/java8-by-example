package com.example.date;
import static java.time.Month.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DurationExample {

	public static void main(String[] args) {
		Duration one24hourDay = Duration.ofDays(1);
		System.out.println("Duration of one day: " + one24hourDay);
		LocalDateTime beforeDST = LocalDateTime.of(2017, JUNE, 5, 12,00);
		ZonedDateTime newYorkTime = ZonedDateTime.of(beforeDST, ZoneId.of("America/New_York"));
		System.out.println("Before: " + newYorkTime);
		System.out.println("After:  " + newYorkTime.plus(one24hourDay));
	}

}
