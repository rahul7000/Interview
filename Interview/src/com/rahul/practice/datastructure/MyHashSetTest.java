package com.rahul.practice.datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

interface MyHashSetInterface<T> {

	void add(T item);

	boolean remove(Object obj);

	int size();

	boolean isEmpty();

	Iterator<T> iterator();
}

/*
@description	:	class to implement HashSet using HashMap
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class MyHashSet<T> implements MyHashSetInterface<T> {

	private Map<T, Object> map;
	private final Object PRESENT;

	public MyHashSet() {
		map = new HashMap<>();
		PRESENT = "Constant";
	}

	@Override
	public void add(T item) {
		map.put(item, PRESENT);
	}

	@Override
	public boolean remove(Object obj) {
		return map.remove(obj) == PRESENT;
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return map.keySet().iterator();
	}

}

/*
@description	:	class to test MyHashSet
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class MyHashSetTest {

	public static void main(String args[]) {
		MyHashSet<Integer> mySet = new MyHashSet<>();

		mySet.add(new Integer(10));
		mySet.add(new Integer(20));
		mySet.add(new Integer(30));

		System.out.println("Size:" + mySet.size());
		System.out.println("IsEmpty:" + mySet.isEmpty());
		System.out.println("Remove:" + mySet.remove(new Integer(30)));

		Iterator<Integer> itr = mySet.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
