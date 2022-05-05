package com.rahul.practice.java8.basicFunctionalities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Reader {
	private int id;
	private String name;
	private List<String> books;

	Reader(int id, String name, List<String> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

}

public class FlatMapTest {

	public static void main(String args[]) {

		String[] rahulBooks = { "Maths", "Science", "Java" };
		String[] gunjanBooks = { "Maths", "Science", "Java" };
		String[] amarBooks = { "Maths", "Science", "Language" };

		Reader rahul = new Reader(1, "Rahul", Arrays.asList(rahulBooks));
		Reader gunjan = new Reader(2, "Gunjan", Arrays.asList(gunjanBooks));
		Reader amar = new Reader(3, "Amar", Arrays.asList(amarBooks));

		List<Reader> readers = new ArrayList<>();
		readers.add(rahul);
		readers.add(gunjan);
		readers.add(amar);

		Integer javaReader = (int) readers.stream().flatMap(reader -> reader.getBooks().stream())
				.filter(book -> book.equalsIgnoreCase("java")).count();
		System.out.println("Java Book Readers are:" + javaReader);

	}

}
