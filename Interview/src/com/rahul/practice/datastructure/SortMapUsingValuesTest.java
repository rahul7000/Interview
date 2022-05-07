package com.rahul.practice.datastructure;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class SortMapUsingValues {
	Map<String, Integer> map;

	SortMapUsingValues(Map<String, Integer> map) {
		this.map = map;
	}

	public Map<String, Integer> sortUsingValues() {

		List<Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		
		Collections.sort( entryList,(entry1,entry2)->entry1.getValue().compareTo(entry2.getValue()));
		
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		Iterator<Entry<String, Integer>> itr = entryList.iterator();
		while (itr.hasNext()) {
			Entry<String, Integer> entry = (Entry<String, Integer>) itr.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}

public class SortMapUsingValuesTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		SortMapUsingValues object = new SortMapUsingValues(map);

		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);

		map.forEach((key, value) -> System.out.println(key + value));
		object.sortUsingValues().forEach((key, value) -> System.out.println(key + value));
	}

}
