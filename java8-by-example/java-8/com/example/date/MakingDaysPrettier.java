package com.example.date;
import static java.time.Month.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class MakingDaysPrettier {

	public static void main(String[] args) {
		//DateTimeFormatter produces formatted date/times
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		System.out.println(now.format(formatter));
		formatter = DateTimeFormatter.ISO_ORDINAL_DATE;
		System.out.println(now.format(formatter));
		formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy G, hh:mm a VV");
		System.out.println(now.format(formatter));
		formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(now.format(formatter));
		formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
		System.out.println(now.format(formatter));
		
		//USING FLUENT NOTATION
		//Not very readable - is this June 11 or November 6th?
		LocalDate myBday = LocalDate.of(1970, 6, 11);
		//A fluent approach
		myBday = Year.of(1970).atMonth(JUNE).atDay(11);
		//Schedule a meeting fluently
		LocalDateTime meeting = LocalDate.of(2017, JUNE, 7).atTime(12,30);
		//Schedule that meeting using the London timezone
		ZonedDateTime meetingUK = meeting.atZone(ZoneId.of("Europe/London"));
		//What time is it in San Francisco for that meeting?
		ZonedDateTime earlyMeeting = meetingUK.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
	}

}
