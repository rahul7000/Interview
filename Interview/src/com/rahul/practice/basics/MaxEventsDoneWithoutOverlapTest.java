package com.rahul.practice.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Event implements Comparable<Event> {
	int startAt;
	int finishAt;
	int position;

	Event(int startAt, int finishAt, int position) {
		this.startAt = startAt;
		this.finishAt = finishAt;
		this.position = position;
	}

	@Override
	public int compareTo(Event o1) {
		if (this.finishAt < o1.finishAt) {
			return -1;
		} else if (this.finishAt > o1.finishAt)
			return 1;
		return 0;

	}
}

public class MaxEventsDoneWithoutOverlapTest {
	public static void main(String[] args) {
		// Arrival time
		List<Integer> arrival = new ArrayList<>();
		arrival.add(5);
		arrival.add(1);
		arrival.add(1);
		arrival.add(1);
		arrival.add(1);
		arrival.add(4);

		List<Integer> duration = new ArrayList<>();
		duration.add(5);
		duration.add(10);
		duration.add(3);
		duration.add(6);
		duration.add(4);
		duration.add(2);

		maxEvents(arrival, duration);
	}

	public static void maxEvents(List<Integer> arrival, List<Integer> duration) {

		ArrayList<Integer> eventList = new ArrayList<>();
		Integer timeLimit = 0;
		ArrayList<Event> events = new ArrayList<>();

		for (int i = 0; i < arrival.size(); i++) {
			events.add(new Event(arrival.get(i), (arrival.get(i) + duration.get(i)), i));
		}

		Collections.sort(events);

		eventList.add(events.get(0).startAt);
		timeLimit = events.get(0).finishAt;

		for (int i = 1; i < arrival.size(); i++) {
			if (events.get(i).startAt >= timeLimit) {
				eventList.add(events.get(i).position);
				timeLimit = events.get(i).finishAt;
			}
		}

		// Print final selected meetings.
		for (int i = 0; i < eventList.size(); i++)
			System.out.print(eventList.get(i) + " ");

	}
}
