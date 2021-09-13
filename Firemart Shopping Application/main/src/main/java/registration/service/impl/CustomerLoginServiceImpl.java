package com.application.registration.service.impl;


import java.util.List;


import com.application.dao.CustomerLoginDAO;
import com.application.dao.impl.CustomerLoginDAOImpl;
import com.application.exception.BusinessException;
import com.application.model.Product;
import com.application.registration.service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService {
	

	private CustomerLoginDAO customerLoginDAO = new CustomerLoginDAOImpl();
	
	@Override
	public int validCustomer(String email, String password) throws BusinessException {
	int c=0;
	 if(email.matches("^[A-Za-z0-9]+[A-Za-z0-9-.]*[@][A-Za-z0-9]+[.][a-zA-Z]+$")) {
		 c=customerLoginDAO.validCustomer(email,password);
	 }else {
		 throw new BusinessException("Invalid email or password");
	 }
	 return c;
	}
	
	@Override
	public List<Product> getAllProducts() throws BusinessException {
		List<Product> products = null;
		products = customerLoginDAO.getAllProducts();
		return products;
	}

	@Override
	public Product getProductById(int id) throws BusinessException {
		Product product = null;
		if (id==0) {
			throw new BusinessException("Invalid Product Id " + id);
		} else {
			product = customerLoginDAO.getProductById(id);
		}
		return product;
	}

	@Override
	public Product getProductByName(String name) throws BusinessException {
		Product product=null;
		product = customerLoginDAO.getProductByName(name);
		return product;
	}




}
