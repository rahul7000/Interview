package com.rahul.practice.datastructure;

import java.util.LinkedList;
import java.util.List;

interface MyHashMapInteface<K, V> {

	void put(K key, V value);

	V get(K key);

	int size();

	boolean isEmpty();

}

/*
@description	:	class to implement hashmap using node class and linkedlist
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class MyHashMap<K, V> implements MyHashMapInteface<K, V> {

	private class Node<K, V> {
		K key;
		V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node<K, V> element;
	private List<Node<K,V>> recordList;

	public MyHashMap() {
		this.recordList = new LinkedList<>();
	}

	public void put(K key, V value) {
		this.element = new Node<K, V>(key, value);

		// check for the same key before adding
		for (int i = 0; i < recordList.size(); i++) {
			Node<K, V> tempElement = recordList.get(i);
			if (tempElement.key.equals(key)) {
				// remove the existing object
				recordList.remove(i);
				break;
			}
		}
		recordList.add(element);
	}

	public V get(K key) {
		for (int i = 0; i < this.recordList.size(); i++) {
			Node<K, V> tempElement = recordList.get(i);

			if (key.toString() == tempElement.key.toString()) {

				return tempElement.value;
			}

		}
		return null;
	}

	@Override
	public int size() {
		return recordList.size();
	}

	@Override
	public boolean isEmpty() {

		return recordList.isEmpty();
	}

}

/*
@description	:	class to test MyHashMap
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class MyHashMapTest {

	public static void main(String args[]) {
		MyHashMap<String, String> myMap = new MyHashMap<>();
		myMap.put("one", "Rahul");
		myMap.put("two", "Raman");
		myMap.put("three", "Rajat");

		System.out.println("Size:"+myMap.size());
		System.out.println("IsEmpty:"+myMap.isEmpty());
		System.out.println("Get:"+myMap.get("three"));
	}
}
