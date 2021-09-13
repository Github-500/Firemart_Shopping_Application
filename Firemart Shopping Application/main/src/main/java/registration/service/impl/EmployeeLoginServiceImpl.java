package com.application.registration.service.impl;

import java.util.List;

import com.application.dao.EmployeeLoginDAO;
import com.application.dao.impl.EmployeeLoginDAOImpl;
import com.application.exception.BusinessException;
import com.application.model.Customer;
import com.application.model.Product;
import com.application.registration.service.EmployeeLoginService;

public class EmployeeLoginServiceImpl implements EmployeeLoginService {

	private EmployeeLoginDAO employeeLoginDAO = new EmployeeLoginDAOImpl();
	static String empEmail = "e";
	static String empPassword = "e";

	@Override
	public int validEmployee(String email, String password) throws BusinessException {

		if (email.equals(empEmail) && password.equals(empPassword)) {
			return 1;
		} else {
			throw new BusinessException("Invalid Email or Password");
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> customer = null;
		customer = employeeLoginDAO.getAllCustomers();
		return customer;
	}

	@Override
	public List<Product> getAllProducts() throws BusinessException {
		List<Product> player = null;
		player = employeeLoginDAO.getAllProducts();
		return player;
	}

	@Override
	public int addProduct(Product product) throws BusinessException {
		int c = 0;
		if (product.getP_id() != 0) {
			if (product.getP_name().matches("[A-Za-z ]{1,}")) {
				if (product.getP_price() != 0) {
					c = employeeLoginDAO.addProduct(product);
				} else {
					throw new BusinessException("Invalid Price " + product.getP_price());
				}
			} else {
				throw new BusinessException("Invalid name " + product.getP_name());
			}
		} else {
			throw new BusinessException("Invalid Id " + product.getP_id());
		}
		return c;
	}

	@Override
	public int deleteProduct(int id) throws BusinessException {
		int c = 0;
		if (id != 0) {
			c = employeeLoginDAO.deleteProduct(id);
		} else {
			throw new BusinessException("Invalid Id ");
		}
		return c;
	}

}
