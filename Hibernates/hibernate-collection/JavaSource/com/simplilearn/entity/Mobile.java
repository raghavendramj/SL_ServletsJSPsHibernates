package com.simplilearn.entity;

import java.util.Map;

public class Mobile {

	private int id;
	private String model;
	private Map<String, String> features;

	public Mobile(String model, Map<String, String> features) {
		super();
		this.model = model;
		this.features = features;
	}

	public Mobile() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Map<String, String> getFeatures() {
		return features;
	}

	public void setFeatures(Map<String, String> features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", model=" + model + ", features=" + features + "]";
	}
	
	
	
}
