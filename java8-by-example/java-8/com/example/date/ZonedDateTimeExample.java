package com.example.date;

import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.zone.ZoneOffsetTransition;

public class ZonedDateTimeExample {
	public static void main(String args[]) {
		//Working with time zones
		ZoneId nyTZ = ZoneId.of("America/New_York");
		ZoneId EST = ZoneId.of("US/Eastern");
		ZoneId Romeo = ZoneId.of("Europe/London");
		//difference from UTC
		ZoneOffset USEast = ZoneOffset.of("-5");
		ZoneOffset Nepal = ZoneOffset.ofHoursMinutes(5, 45);
		ZoneId EST_b = ZoneId.ofOffset("UTC", USEast);
		
		//Stores LocalDateTime, ZoneId, and ZoneOffset
		LocalDate date = LocalDate.of(2017, JUNE, 2);
		LocalTime time = LocalTime.of(9, 30);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		ZonedDateTime courseStart = ZonedDateTime.of(date, time, nyTZ);
		ZonedDateTime hereNow = ZonedDateTime.now(nyTZ).truncatedTo(MINUTES);
		System.out.println("Here now:         " + hereNow);
		System.out.println("Course starts:    " + courseStart);
		ZonedDateTime newCourseStart = courseStart.plusDays(2).minusMinutes(30);
		System.out.println("New Course Start: " + newCourseStart);
		
		//Working with ZonedDateTime Gaps/Overlaps
		//DST Begins June 7th, 2017
		System.out.println();
		LocalDate meetDate = LocalDate.of(2017, JUNE, 7);
		LocalTime meetTime = LocalTime.of(12, 30);
		ZonedDateTime meeting = ZonedDateTime.of(meetDate, meetTime, nyTZ);
		System.out.println("Meeting time:     " + meeting);
		ZonedDateTime newMeeting = meeting.plusDays(1);
		System.out.println("New meeting time: " + newMeeting);
		
		//ZoneRules
		//Ask the rules if there was a gap or overlap
		System.out.println();
		LocalDateTime lateNight = LocalDateTime.of(2017, MARCH, 9, 2, 30);
		ZoneOffsetTransition zot = nyTZ.getRules().getTransition(lateNight);
		if(zot != null) {
			if(zot.isGap()) {
				System.out.println("gap");
			} 
			
			if(zot.isOverlap()) {
				System.out.println("overlap");
			}
		} else {
			System.out.println("No vemos una mierda");
		}
		
		//Working Across Time Zones
		System.out.println();
		LocalDateTime myMeeting = LocalDateTime.of(2017, JUNE, 7, 12, 30);
		ZoneId SanFran = ZoneId.of("America/Los_Angeles");
		ZonedDateTime staffCall = ZonedDateTime.of(myMeeting, SanFran);
		OffsetDateTime offSet = staffCall.toOffsetDateTime();
		//The offset is used to calculate date/time using zone rules
		ZoneId London = ZoneId.of("Europe/London");
		ZonedDateTime staffCallUK = offSet.atZoneSameInstant(London);
		System.out.println("Staff call (Pacific) is at: " + staffCall);
		System.out.println("Staff call (UK) is at:      " + staffCallUK );
	}
}
