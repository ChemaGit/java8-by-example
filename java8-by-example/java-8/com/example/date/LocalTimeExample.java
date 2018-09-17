package com.example.date;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.*;

public class LocalTimeExample {

	public static void main(String[] args) {
		//Que pasa
		LocalTime now, nowPlus, nowHrsMins, lunch, bedTime;
		now = LocalTime.now();
		System.out.println("Now: " + now);
		nowPlus = now.plusHours(1).plusMinutes(15);
		System.out.println("What time is it 1 hour 15 minutes from now? " + nowPlus);
		nowHrsMins = now.truncatedTo(MINUTES);
		System.out.println("Truncate the current time to minutes: " + nowHrsMins);
		System.out.println("It is the " + now.toSecondOfDay()/60 + "th minute.");
		lunch = LocalTime.of(12, 30);
		System.out.println("Is lunch in my future? " + lunch.isAfter(now));
		long minsToLunch = now.until(lunch, MINUTES);
		System.out.println("Minutes until lunch: " + minsToLunch);
		bedTime = LocalTime.of(21, 30);
		long hrsToBedTime = now.until(bedTime, HOURS);
		System.out.println("How many hours until Bed time: " + hrsToBedTime);
	}

}
