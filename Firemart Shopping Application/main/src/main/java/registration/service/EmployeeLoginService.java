package com.application.registration.service;

import java.util.List;

import com.application.exception.BusinessException;
import com.application.model.Customer;
import com.application.model.Product;

public interface EmployeeLoginService {

	public  int validEmployee(String email,String password) throws BusinessException;
	
	public List<Customer> getAllCustomers() throws BusinessException;
	
	public List<Product> getAllProducts() throws BusinessException;
	
	public int addProduct(Product product) throws BusinessException;
	
	public int deleteProduct(int id) throws BusinessException;
	
}
