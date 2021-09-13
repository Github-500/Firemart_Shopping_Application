package com.application.dao;

import java.util.List;


import com.application.exception.BusinessException;
import com.application.model.Product;

public interface CustomerLoginDAO {

	public  int validCustomer(String email,String password) throws BusinessException;
	
	public List<Product> getAllProducts() throws BusinessException;

	public Product getProductById(int id) throws BusinessException;
	
	public Product getProductByName(String name) throws BusinessException;
	
}
