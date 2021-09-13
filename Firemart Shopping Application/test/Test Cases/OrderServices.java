package online_shopping_application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.application.exception.BusinessException;
import com.application.registration.service.OrderService;
import com.application.registration.service.impl.OrderServiceImpl;

class OrderServices {
OrderService orderService = new OrderServiceImpl();
	
	@Test
	public void getAllOrder() throws BusinessException {
		
		assertNotNull(orderService.getAllOrders(1));
	}

}
