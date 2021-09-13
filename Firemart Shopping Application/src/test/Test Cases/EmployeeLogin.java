package online_shopping_application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.application.exception.BusinessException;
import com.application.model.Product;
import com.application.registration.service.EmployeeLoginService;
import com.application.registration.service.impl.EmployeeLoginServiceImpl;

class EmployeeLogin {

	EmployeeLoginService employeeLoginService = new EmployeeLoginServiceImpl();

	@Test
	void addProducts() throws BusinessException {
		
		Product product = new Product(13, "Dell Laptop", 1100.00);

		assertNotNull(employeeLoginService.addProduct(product));

		Product product1 = new Product(14, "MacBook Laptop", 1500.00);

		assertNotNull(employeeLoginService.addProduct(product1));

	}
	@Test
	void deleteProducts() throws BusinessException {
		
		assertEquals(1,employeeLoginService.deleteProduct(13));
	}
	@Test
	void getAllCustomer() throws BusinessException {

		assertNotNull(employeeLoginService.getAllCustomers());
	}
	@Test
	public void getAllProduct() throws BusinessException {
		
		assertNotNull(employeeLoginService.getAllProducts());
		
}
	@Test
	public void validEmployee() throws BusinessException {
		
		assertEquals(1,employeeLoginService.validEmployee("e","e"));
		
}

}
