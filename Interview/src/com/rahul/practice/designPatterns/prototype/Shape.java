package com.rahul.practice.designPatterns.prototype;

public abstract class Shape implements Cloneable {

	String id;
	String type;

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract void draw();

	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.getMessage();
		}
		return clone;

	}
}
