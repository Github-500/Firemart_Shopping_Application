package com.application.registration.service.impl;

import java.util.List;

import com.application.dao.CartDAO;
import com.application.dao.impl.CartDAOImpl;
import com.application.exception.BusinessException;
import com.application.model.Cart;
import com.application.registration.service.CartService;

public class CartServiceImpl implements CartService{

	private CartDAO cartDAO = new CartDAOImpl();
	@Override
	public int addCartProduct(int id,int customer_id) throws BusinessException {
		int c=0;
		if(id==0) {
			throw new BusinessException("Invalid Id"+id);
		}else {
			c=cartDAO.addCartProduct(id,customer_id);
		}
		return c;
	}

	@Override
	public List<Cart> getCartProducts(int customer_id) throws BusinessException {
		List<Cart> cart = null;
		cart = cartDAO.getCartProducts(customer_id);
		return cart;
	}

	@Override
	public int deleteCartProduct(int id,int cust_id) throws BusinessException {
		int c=0;
		if(id==0) {
			throw new BusinessException("Invalid Id"+id);
		}else {
			c=cartDAO.deleteCartProduct(id,cust_id);
		}
		return c;
	}

	@Override
	public int emptyCart(int customer_id) throws BusinessException {
		int c=0;
		c=cartDAO.emptyCart(customer_id);
		return c;
	}
}
