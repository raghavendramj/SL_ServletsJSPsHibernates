package com.simplilearn.entity;

import java.util.List;

public class Student {

	private int id;
	private String name;
	private String email;

	List<Course> courses;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(String name, String email, List<Course> courses) {
		super();
		this.name = name;
		this.email = email;
		this.courses = courses;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", name=" + name + ", email=" + email + ", courses=" + courses + "]";
	}
	
}
