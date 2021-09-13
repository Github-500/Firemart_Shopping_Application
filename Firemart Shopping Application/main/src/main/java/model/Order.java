package com.application.model;

public class Order {
	
	private int order_id;
	private int customer_id;
	private int product_id;
	private String product_name;
	private double product_price;
	private String order_status;
	
	public Order() {
		
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "Order [order_id= "+order_id+", customer_id=" + customer_id + ", product_id=" + product_id
				+ ", product_name=" + product_name + ", product_price=" + product_price + ", order_status="
				+ order_status + "]";
	}

	public Order(int order_id, int customer_id, int product_id, String product_name, double product_price,
			String order_status) {
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.order_status = order_status;
	}

	

	
}
