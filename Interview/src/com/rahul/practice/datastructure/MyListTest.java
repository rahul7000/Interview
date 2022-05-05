package com.rahul.practice.datastructure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface MyListInterface<T> {

	// remove last item from list
	T removeLast();

	// add item at the last of list
	void addLast(T item);

	// remove first item from list
	T removeFirst();

	// add item at the head of list
	void addFirst(T item);

	// returns the number of items in list right now
	int size();

	// detect loop using Floyd’s Cycle-Finding Algorithm
	boolean detectLoopUsingFloyd();

	// detect loop using HashMap, same complexity as above O(n)
	boolean detectLoopUsingMap();

	// returns true if list is empty, false otherwise
	boolean isEmpty();

	// remove first occurrence of item from list
	T removeFirstOccurrence(T item);

	// remove item from the index of list
	T removeFromIndex(Integer index);

	// remove all occurrence of item from list
	List<T> removeAllOccurrences(T item);

	// remove all the items from list
	void removeAll();

	// add item after a particular index in list
	void addAtIndex(T item, Integer index);

	// add item after a particular item in list
	void addAfter(T itemAfter, T itemToAdd);

	// add item after a particular item in list
	void addAll(MyList<T> list);

	// add another list in sorted order
	void addSortedAll(MyList<T> list);

	// add an item and make list sorted
	void addAfterSorting(T item);

	// remove an item and make list sorted
	T removeAfterSorting();

	// sort the list in ascending order
	void sortAsc();

	// sort the list in descending order
	void sortDesc();

	// get the nearest greater number
	void floorItem(T item);

	// get the nearest greater number
	void cielingItem(T item);

	// get the index of item in list
	int getIndex(T item);

	// swap items at their indexes in list
	int swap(T item1, T item2);

	// swap two index values in list
	int swap(Integer fromIndex, Integer toIndex);

	// print all items of a list
	void printAll();

	// print values of even indexes only
	void printEvenIndexes();

	// print values of odd indexes only
	void printOddIndexes();

	// print values at index only
	void print(Integer index);

	// print values in reverse order
	void printAllReverse();

	// print type of item in list
	void printItemType();

	// print first item from list
	void printFirst();

	// print last item of list
	void printLast();

	// print middle element from the list
	void printMiddle();

	// lock the MyList object
	void synchronizedMyList(MyList<? extends T> list);

	// print size,type of container class, first element, last element, middle
	// element
	void printStatistics();

	// print number of occurrence of item in list
	void printOccurrence(T item);

	// get new list by reversing one
	void reverse();

	// returns the iterator to iterate through the list
	Iterator<T> iterator();

}

/*
 * @description : class to implement MyListInterface 1->2->3->4->5->null
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 21-Jan-2021
 */
class MyList<T> implements MyListInterface<T> {

	private class Node<T> {

		T item;
		Node<T> next;

		// this can be used directly to addFirst(next->head)
		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node<T> head;
	private Integer size;

	private final Integer STARTING_SIZE = new Integer(0);
	private final Integer STARTING_INDEX = new Integer(0);

	public MyList() {
		this.head = null;
		this.size = STARTING_SIZE;
	}

	private Node<T> getHeadNode() {
		return head;
	}

	private Node<T> getTailNode() {

		Node<T> tempTail = head;

		// loop to stand on the last item
		while (tempTail.next != null) {
			tempTail = tempTail.next;
		}
		return tempTail;
	}

	private Node<T> getPrevious(Integer index) {

		Node<T> tempNode = head;
		Node<T> prevNode = null;
		Integer tempIndex = STARTING_INDEX;

		// loop to find the previous node of index
		while (tempNode != null && !tempIndex.equals(index)) {
			prevNode = tempNode;
			tempNode = tempNode.next;
			tempIndex++;
		}
		return prevNode;
	}

	private Node<T> getPrevious(T item) {

		Node<T> tempNode = head;
		Node<T> prevNode = null;

		// loop to find the previous node of item
		while (tempNode != null && !tempNode.item.equals(item)) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		return prevNode;

	}

	private Node<T> getCurrentNode(T item) {

		Node<T> tempNode = head;

		// loop to find the current node of item
		while (tempNode != null && !tempNode.item.equals(item)) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}

	private Node<T> getCurrentNode(Integer index) {

		Node<T> tempNode = head;
		Integer tempIndex = STARTING_INDEX;

		// loop to find the current node of item
		while (tempNode != null && !tempIndex.equals(index)) {
			tempNode = tempNode.next;
			tempIndex++;
		}
		return tempNode;
	}

	private Map<String, MyList<T>.Node<T>> getNodeInfo(Integer index) {

		Node<T> tempNode = head;
		Node<T> prevNode = null;
		Integer tempIndex = STARTING_INDEX;
		Map<String, MyList<T>.Node<T>> infoMap = new LinkedHashMap<>();

		// loop to find the previous node of index
		while (tempNode != null && !tempIndex.equals(index)) {
			prevNode = tempNode;
			tempNode = tempNode.next;
			tempIndex++;
		}

		infoMap.put("previousNode", prevNode);
		infoMap.put("currentNode", tempNode);
		infoMap.put("nextNode", tempNode.next);

		return infoMap;
	}

	private Map<String, MyList<T>.Node<T>> getNodeInfo(T item) {

		Node<T> tempNode = head;
		Node<T> prevNode = null;
		Map<String, MyList<T>.Node<T>> infoMap = new LinkedHashMap<>();

		// loop to find the previous node of item
		while (tempNode != null && !tempNode.item.equals(item)) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}

		infoMap.put("previousNode", prevNode);
		infoMap.put("currentNode", tempNode);
		infoMap.put("nextNode", tempNode.next);

		return infoMap;
	}

	@SuppressWarnings({ "unchecked", "hiding", "rawtypes" })
	private class MyListIterator<T> implements Iterator<T> {

		private Integer tempSize = size;

		private Node newHead = head;

		@Override
		public boolean hasNext() {
			return tempSize > 0;
		}

		@Override
		public T next() {
			T item = (T) newHead.item;
			newHead = newHead.next;
			tempSize--;
			return item;
		}

	}

	@Override
	public T removeLast() {

		T removedItem = null;
		Node<T> tempNode = head;
		Node<T> prevNode = null;

		if (head == null) {
			System.out.println("UnderFlow:");
			return removedItem;
		}

		if (size.equals(STARTING_INDEX)) {
			removedItem = head.item;
			head = null;
			size--;
			return removedItem;
		}

		// loop to get last and 2nd last item
		// can use getPreviousNode(size) and getCurrentNode(size) but more costly
		while (tempNode.next != null) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}

		if (prevNode != null && tempNode != null) {
			removedItem = tempNode.item;
			prevNode.next = tempNode.next;
			tempNode = null;
			size--;
		}

		return removedItem;
	}

	@Override
	public void addLast(T item) {

		Node<T> newNode = new Node<T>(item, null);

		if (head == null) {
			head = newNode;
			size++;
			return;
		}

		Node<T> tailNode = this.getTailNode();

		if (tailNode != null) {
			tailNode.next = newNode;
			size++;
		}
	}

	@Override
	public T removeFirst() {

		Node<T> tempNode = head;
		T removedItem = null;

		if (head == null) {
			System.out.println("UnderFlow:");
			return removedItem;
		}

		removedItem = tempNode.item;
		tempNode = tempNode.next;
		head = tempNode;
		size--;

		return removedItem;
	}

	@Override
	public void addFirst(T item) {

		Node<T> newNode = new Node<T>(item, null);
		Node<T> tempNode = head;

		head = newNode;
		head.next = tempNode;
		size++;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public T removeFirstOccurrence(T item) {

		Node<T> tempNode = head;
		Node<T> prevNode = null;
		T removedItem = null;

		// CASE 1: If head node itself holds the item to be deleted
		if (tempNode != null && tempNode.item.equals(item)) {
			removedItem = tempNode.item;
			head = tempNode.next;
			size--;
			return removedItem;
		}

		// CASE 2: If the item is somewhere other than at head
		// keep track of the previous node as it is needed
		// can use getPreviousNode(item) and getCurrentNode(item) but more costly
		while (tempNode != null && !tempNode.item.equals(item)) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}

		// If the item should be at tempNode Therefore the tempNode must not be null
		if (prevNode != null && tempNode != null) {
			removedItem = tempNode.item;
			prevNode.next = tempNode.next;
			size--;
			return removedItem;

		}

		// CASE 3: The item is not present
		if (tempNode == null) {
			System.out.println(item + " not found");
		}
		return removedItem;

	}

	@Override
	public T removeFromIndex(Integer index) {

		Node<T> tempNode = head;
		Node<T> prevNode = null;
		Integer indexCounter = STARTING_INDEX;
		T removedItem = null;

		if (size < index) {
			System.out.println("OverFlow:");
			return removedItem;
		}

		// CASE 1: for head only
		if (index.equals(indexCounter)) {
			removedItem = head.item;
			head = head.next;
			size--;
			return removedItem;
		}

		// CASE 2: If the index is somewhere other than at head
		while (tempNode != null && !indexCounter.equals(index)) {

			prevNode = tempNode;
			tempNode = tempNode.next;
			indexCounter++;
		}

		if (prevNode != null && tempNode != null) {
			removedItem = tempNode.item;
			prevNode.next = tempNode.next;
			size--;
		}
		return removedItem;
	}

	@Override
	public List<T> removeAllOccurrences(T item) {
		Node<T> tempNode = head;
		Integer indexCounter = STARTING_INDEX;
		List<T> removedItemList = null;

		if (head == null) {
			System.out.println("UnderFlow:");
			return removedItemList;
		}

		removedItemList = new LinkedList<T>();
		// TODO: Better complexity with one loop only
		while (tempNode != null) {
			if (tempNode.item.equals(item)) {
				removedItemList.add(tempNode.item);
				removeFromIndex(indexCounter);
				// no need to change the index as already done in removeFromIndex
				// size--;
			} else {
				indexCounter++;
			}
			tempNode = tempNode.next;
		}
		return removedItemList;

	}

	@Override
	public void removeAll() {
		Node<T> backupNode = head;

		// Create the backupNode of head, head=null for GC, set head to backupNode
		while (head != null) {
			backupNode = head.next;
			head = null;
			head = backupNode;
			size--;
		}

	}

	@Override
	public void addAtIndex(T item, Integer index) {

		Node<T> newNode = new Node<T>(item, null);
		Node<T> tempNode = head;
		Node<T> prevNode = null;
		Integer indexCounter = STARTING_INDEX;

		if (size.equals(index)) {
			addLast(item);
			return;
		}

		if (index.equals(indexCounter)) {
			head = newNode;
			head.next = tempNode;
			size++;
			return;
		}

		// can use Map<String, MyList<T>.Node<T>> getNodeInfo(Integer index)
		// Map<String, MyList<T>.Node<T>> infoMap = getNodeInfo(index);
		// prevNode = infoMap.get("previousNode");
		// Node<T> currentNode = infoMap.get("currentNode");

		while (tempNode != null && indexCounter.equals(index)) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}

		if (prevNode != null && tempNode != null) {
			prevNode.next = newNode;
			newNode.next = tempNode;
			size++;
		}

	}

	@Override
	public void addAfter(T itemAfter, T itemToAdd) {

		Node<T> tempNode = head;
		Node<T> prevNode = null;
		Node<T> newNode = new Node<T>(itemToAdd, null);

		if (head == null) {
			head = newNode;
			return;
		}

		if (head.item.equals(itemAfter)) {
			head = newNode;
			head.next = tempNode.next;
			size++;
			return;
		}

		// can use Map<String, MyList<T>.Node<T>> getNodeInfo(T item)
		while (tempNode != null && tempNode.item.equals(itemAfter)) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}

		if (prevNode != null && tempNode != null) {
			prevNode.next = newNode;
			newNode.next = tempNode;
			size++;
		}

	}

	@Override
	public void addAll(MyList<T> list) {

		Node<T> listHead = list.getHeadNode();
		Integer listSize = list.size();
		Node<T> currentTailNode = this.getTailNode();

		// CASE 1: when first list is empty
		if (head == null) {
			head = listHead;
			size = listSize;
			return;
		}

		// CASE 2: when first list is not empty
		currentTailNode.next = listHead;
		size = size + listSize;

	}

	@Override
	public void sortAsc() {
		// 9->7->2->3->6->null
		// we maintain two pointers: current and next. Initially, current point to head
		// node and next will point to node next to current. Traverse through the list
		// till current points to null, by comparing current's data with next's data.
		// If current's data is greater than the next's data, then swap data between
		// them. In the above example, current will initially point to 9 and index will
		// point to 7. Since, 9 is greater than 7, swap the data. Continue this process
		// until the entire list is sorted in ascending order

		Node<T> currentNode = this.head;
		Node<T> nextNode = null;
		T tempItem = null;

		if (currentNode == null) {
			System.out.println("UnderFlow:");
			return;
		}

		// if (currentNode instanceof Number) {
		//
		// }

		while (currentNode != null) {
			nextNode = currentNode.next;

			while (nextNode != null) {
				// if (currentNode.item < nextNode.item) {
				// tempItem = nextNode.item;
				// nextNode.item = currentNode.item;
				// currentNode.item = tempItem;
				// }
				nextNode = nextNode.next;
			}
			currentNode = currentNode.next;
		}
	}

	@Override
	public void addSortedAll(MyList<T> list) {

		Node<T> listHead = list.getHeadNode();
		Integer listSize = list.size();
		Node<T> tempNode = head;
		Node<T> currentTailNode = this.getTailNode();

		// MyList<T> sortedList = this.sortAsc(list);

		// CASE 1: when first list is empty
		if (head == null) {
			head = listHead;
			size = listSize;
			return;
		}

	}

	@Override
	public void addAfterSorting(T item) {
		// TODO Auto-generated method stub

	}

	@Override
	public T removeAfterSorting() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sortDesc() {

	}

	@Override
	public void floorItem(T item) {

	}

	@Override
	public void cielingItem(T item) {

	}

	@Override
	public int getIndex(T item) {

		return 0;
	}

	@Override
	public int swap(T item1, T item2) {
		return 0;
	}

	@Override
	public int swap(Integer fromIndex, Integer toIndex) {

		return 0;
	}

	@Override
	public void reverse() {
		Node<T> prevNode = null;
		Node<T> currentNode = head;
		Node<T> nextNode = null;

		if (head == null) {
			System.out.println("UnderFlow");
			return;
		}

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		head = prevNode;
	}

	@Override
	public void printAll() {

		Node<T> tempNode = head;

		while (tempNode != null) {
			System.out.print(tempNode.item + " ");
			tempNode = tempNode.next;
		}
	}

	@Override
	public void printEvenIndexes() {
		Node<T> tempNode = head;
		Integer indexCounter = STARTING_INDEX;

		while (tempNode != null) {
			if (indexCounter % 2 == 0) {
				System.out.println(tempNode.item);
			}
			tempNode = tempNode.next;
			indexCounter++;
		}
	}

	@Override
	public void printOddIndexes() {

		Node<T> tempNode = head;
		Integer indexCounter = STARTING_INDEX;

		while (tempNode != null) {
			if (indexCounter % 2 != 0) {
				System.out.println(tempNode.item);
			}
			tempNode = tempNode.next;
			indexCounter++;
		}
	}

	@Override
	public void print(Integer index) {

		Node<T> tempNode = head;
		Integer indexCounter = STARTING_INDEX;

		if (size < index) {
			System.out.println("OverFlow:");
			return;
		}

		while (tempNode != null && !indexCounter.equals(index)) {
			tempNode = tempNode.next;
			indexCounter++;
		}

		if (tempNode != null) {
			System.out.println(tempNode.item);
		}

	}

	@Override
	public void printAllReverse() {

		// TODO: Better approach to do so
		for (int i = size; i > STARTING_INDEX; i--) {
			print(i);
		}
	}

	@Override
	public void printItemType() {

	}

	@Override
	public void printFirst() {

	}

	@Override
	public void printLast() {

	}

	@Override
	public void printMiddle() {

		Node<T> slowNode = head;
		Node<T> fastNode = head;
		Node<T> prevNode = null;

		while (fastNode != null && fastNode.next != null) {
			prevNode = slowNode;
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		if (size % 2 != 0) {
			System.out.println("Middle Element is: " + slowNode.item);
		} else {
			System.out.println("Middle Elements are: " + prevNode.item + " and " + slowNode.item);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyListIterator();
	}

	@Override
	public boolean detectLoopUsingFloyd() {
		Node<T> slowNode = head;
		Node<T> fastNode = head;
		boolean flag = false;

		if (head == null) {
			System.out.println("UnderFlow:");
			return flag;
		}

		while (slowNode != null && fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;

			if (slowNode == fastNode) {
				flag = true;
				break;
			}

		}

		return flag;
	}

	@Override
	public boolean detectLoopUsingMap() {
		Node<T> tempNode = head;
		boolean flag = false;
		HashSet<T> set = new HashSet<>();
		
		if (head == null) {
			System.out.println("UnderFlow:");
			return flag;
		}

		while (tempNode != null) {
			if (set.contains(tempNode.item)) {
				flag = true;
				break;
			}

			set.add(tempNode.item);
			tempNode = tempNode.next;
		}
		return flag;
	}

	@Override
	public void synchronizedMyList(MyList list) {

	}

	@Override
	public void printStatistics() {

	}

	@Override
	public void printOccurrence(T item) {

	}

}

/*
 * @description : class to test MyList
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 21-Jan-2021
 */
public class MyListTest {
	public static void main(String args[]) {
		MyList<Integer> myList = new MyList<>();

		myList.addLast(new Integer(10));
		myList.addLast(new Integer(30));
		myList.addLast(new Integer(40));
		myList.addLast(new Integer(20));
		myList.addLast(new Integer(60));
		myList.addLast(new Integer(50));

		Iterator<Integer> itr = myList.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println("\nSize:" + myList.size());
		System.out.println("IsEmpty:" + myList.isEmpty());
		System.out.println("PrintMiddle:");
		myList.printMiddle();
		myList.reverse();
		myList.printAll();
		System.out.println("\nLoop Detected: " + myList.detectLoopUsingFloyd());
		System.out.println("Loop Detected: " + myList.detectLoopUsingMap());
	}
}
