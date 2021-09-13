package com.application.model;

public class Customer {
	private int id;
	private String name;
	private String email;
	private String password;
	private Long contact;
	private String gender;
	private String address;
	
	public Customer() {
		
	}
	public Customer(int id, String name, String email, String password, Long contact, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password=password;
		this.contact = contact;
		this.gender = gender;
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
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

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", contact="
				+ contact + ", gender=" + gender + ", address=" + address + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
