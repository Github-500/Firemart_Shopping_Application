package online_shopping_application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.application.exception.BusinessException;
import com.application.registration.service.CustomerLoginService;
import com.application.registration.service.impl.CustomerLoginServiceImpl;

class CustomerLogin {

CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
	
	@Test
	public void getProductById() throws BusinessException {
		
		assertNotNull(customerLoginService.getProductById(10));
		
}
	@Test
	public void getProductByName() throws BusinessException {
		
		assertNotNull(customerLoginService.getProductByName("Blue Star Ac"));
		
}
	
	@Test
	public void ValidCustomer() throws BusinessException {
		
		assertNotNull(customerLoginService.validCustomer("admin@gmail.com","admin@123"));
		
	}

}
