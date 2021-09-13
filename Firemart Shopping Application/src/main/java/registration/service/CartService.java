package com.application.registration.service;


import java.util.List;

import com.application.exception.BusinessException;
import com.application.model.Cart;

public interface CartService {

	
	public int addCartProduct(int id,int customer_id) throws BusinessException;
	
	public int deleteCartProduct(int id,int cust_id) throws BusinessException;
	
	public List<Cart> getCartProducts(int customer_id) throws BusinessException;

	public int emptyCart(int customer_id) throws BusinessException;
}
