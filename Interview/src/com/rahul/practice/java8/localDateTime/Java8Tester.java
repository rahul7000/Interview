package com.rahul.practice.java8.localDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Java8Tester {

	public static void main(String... strings) {
		System.out.println("Test new Date-Time API");
		Java8Tester tester = new Java8Tester();

		tester.getLocalDateTimeTest();
	}

	private void getLocalDateTimeTest() {

		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current Time : " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1 : " + date1);

		LocalTime date2 = currentTime.toLocalTime();
		System.out.println("date2 : " + date2);

		Month month = currentTime.getMonth();
		int dayOftheMonth = currentTime.getDayOfMonth();
		int dayOfTheYear = currentTime.getDayOfYear();
		int seconds = currentTime.getSecond();
		System.out.println("Month : " + month + " DayOfTheMonth : " + dayOftheMonth + " DayOfTheYear : " + dayOfTheYear
				+ " Seconds : " + seconds);

		LocalDateTime date3 = currentTime.withDayOfMonth(10).withYear(2);
		System.out.println("date3 : " + date3);

		LocalDate date4 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date4 : " + date4);

		LocalTime date5 = LocalTime.of(10, 20);
		System.out.println("date5 : " + date5);

		LocalTime date6 = LocalTime.parse("20:10:15");
		System.out.println("date6 : " + date6);
	}
}
