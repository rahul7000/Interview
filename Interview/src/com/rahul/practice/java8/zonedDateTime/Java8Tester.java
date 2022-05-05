package com.rahul.practice.java8.zonedDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Java8Tester {

	public static void main(String... strings) {
		Java8Tester tester = new Java8Tester();
		tester.testZonedDateTime();
	}

	private void testZonedDateTime() {
		System.out.println("Test new ZonedDateTime API");

		ZonedDateTime date1 = ZonedDateTime.now();
		System.out.println("date1 : " + date1);

		ZonedDateTime date2 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
		System.out.println("date2 : " + date2);

		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("id : " + id);

		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("currentZone : " + currentZone);

		ZonedDateTime date3 = ZonedDateTime.now(id);
		System.out.println("date3 : " + date3);
	}
}
