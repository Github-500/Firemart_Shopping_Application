package com.application.model;

public class Cart {

	private int c_id;
	private int customer_id;
	private String c_name;
	private double c_price;

	public Cart() {

	}

	public Cart(int c_id, int customer_id, String c_name, double c_price) {
		super();
		this.c_id = c_id;
		this.customer_id = customer_id;
		this.c_name = c_name;
		this.c_price = c_price;
	}
	
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public double getC_price() {
		return c_price;
	}

	public void setC_price(double c_price) {
		this.c_price = c_price;
	}

	@Override
	public String toString() {
		return "Cart [c_id=" + c_id + ", customer_id=" + customer_id + ", c_name=" + c_name + ", c_price=" + c_price
				+ "]";
	}

}
