package online_shopping_application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.application.exception.BusinessException;
import com.application.registration.service.CartService;
import com.application.registration.service.impl.CartServiceImpl;

class CartServices {
	
	CartService cartService = new CartServiceImpl();
	@Test
	void addProductsToCart() throws BusinessException {
		assertEquals(1,cartService.addCartProduct(11,1));
	}
	@Test
	void deleteProductsFromCart() throws BusinessException {
		assertEquals(12346,cartService.deleteCartProduct(12,2));
	}
	@Test
	public void getAllCartProducts() throws BusinessException {		
		assertNotNull(cartService.getCartProducts(10));
}
	@Test
	public void isCartEmpty() throws BusinessException {
		assertNotEquals(0,cartService.emptyCart(1));
}
}
