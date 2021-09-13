package com.application.dao;

import com.application.exception.BusinessException;
import com.application.model.Customer;

public interface CustomerRegistrationDAO {

	public  int createCustomer(Customer customer) throws BusinessException;

}
