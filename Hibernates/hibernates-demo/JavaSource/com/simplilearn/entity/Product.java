package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "product_name")
	private String name;
	private String quantity_in_stock;
	private String unit_price;

	public Product(String name, String quantity_in_stock, String unit_price) {
		super();
		this.name = name;
		this.quantity_in_stock = quantity_in_stock;
		this.unit_price = unit_price;
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

	public String getQuantity_in_stock() {
		return quantity_in_stock;
	}

	public void setQuantity_in_stock(String quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

}
