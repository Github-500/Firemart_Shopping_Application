package com.application.registration.service;

import com.application.exception.BusinessException;
import com.application.model.Customer;

public interface CustomerRegistrationService {

	public  int createCustomer(Customer customer) throws BusinessException;
}
