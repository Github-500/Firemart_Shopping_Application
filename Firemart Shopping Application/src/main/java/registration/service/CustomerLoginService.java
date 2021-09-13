package com.application.registration.service;

import java.util.List;


import com.application.exception.BusinessException;
import com.application.model.Product;

public interface CustomerLoginService {

	public  int validCustomer(String email,String password) throws BusinessException;
		
	public List<Product> getAllProducts() throws BusinessException;

	public Product getProductByName(String name) throws BusinessException;
	
	public Product getProductById(int id) throws BusinessException;


}
