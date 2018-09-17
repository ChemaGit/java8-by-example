package com.example.date;

import java.time.Instant;

public class DateTimeAmountsExample {

	public static void main(String[] args) throws Exception {
		// Date and Time Amounts
		Instant now = Instant.now();
		Thread.sleep(0, 1);
		Instant later = Instant.now();
		System.out.println("Now is before later? " + now.isBefore(later));
		System.out.println("Now:       " + now);
		System.out.println("Later:     " + later);

	}

}
