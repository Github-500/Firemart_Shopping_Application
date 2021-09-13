package com.application.registration.service.impl;

import com.application.dao.CustomerRegistrationDAO;
import com.application.dao.impl.CustomerRegistrationDAOImpl;
import com.application.exception.BusinessException;
import com.application.model.Customer;
import com.application.registration.service.CustomerRegistrationService;

public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

	private CustomerRegistrationDAO customerRegistrationDAO = new CustomerRegistrationDAOImpl();

	@Override
	public int createCustomer(Customer customer) throws BusinessException {

		int c = 0;
		if (customer.getId() != 0) {
			if (customer.getName().matches("^[A-Za-z ]{3,30}$")) {
				if (customer.getEmail().matches("^[A-Za-z0-9]+[A-Za-z0-9-.]*[@][A-Za-z0-9]+[.][a-zA-Z]+$")) {
					if (String.valueOf(customer.getContact()).matches("[1-9]{1}[0-9]{9}")) {
						if (customer.getGender().matches("^[M|F]{1}$")) {
							if (customer.getAddress().matches("^[A-Za-z ]{1,30}$")) {
								c = customerRegistrationDAO.createCustomer(customer);
							} else {
								throw new BusinessException("Invalid Gender " + customer.getGender());
							}
						} else {
							throw new BusinessException("Invalid Gender " + customer.getGender());
						}
					} else {
						throw new BusinessException("Invalid contact ");
					}
				} else {
					throw new BusinessException("Invalid email " + customer.getEmail());
				}
			} else {
				throw new BusinessException("Invalid name " + customer.getName());
			}
		} else {
			throw new BusinessException("Invalid id ");
		}
		return c;
	}

}
