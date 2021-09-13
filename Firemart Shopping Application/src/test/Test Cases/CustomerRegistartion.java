package online_shopping_application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.application.exception.BusinessException;
import com.application.model.Customer;
import com.application.registration.service.CustomerRegistrationService;
import com.application.registration.service.impl.CustomerRegistrationServiceImpl;

class CustomerRegistartion {
	
	private CustomerRegistrationService customerRegistrationDAO = new CustomerRegistrationServiceImpl();
	@Test
	void createNewCustomer() throws BusinessException {
			
			Customer customer=new Customer(123456,"Admin","admin55@jmail.com","admin@173",78754677878L,"M","Mumbai");
			assertNotNull(customerRegistrationDAO.createCustomer(customer));
			customer=new Customer(1234567,"Admin23","admin23@jmail.com","admin23@173",7876777878L,"M","Kerala");
			assertNotNull(customerRegistrationDAO.createCustomer(customer));
	}

}
