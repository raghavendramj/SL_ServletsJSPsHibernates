package com.simplilearn.entity;

import java.util.List;

public class User {

	private int id;
	private String name;
	private List<String> hobbies;

	public User() {
		super();
	}

	public User(String name, List<String> hobbies) {
		super();
		this.name = name;
		this.hobbies = hobbies;
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

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", hobbies=" + hobbies + "]";
	}
}
