package com.application.registration.service;

import java.util.List;

import com.application.exception.BusinessException;
import com.application.model.Order;

public interface OrderService {

	public int placeOrder(int customer_id) throws BusinessException;

	public List<Order> getAllOrders(int customer_id) throws BusinessException;

	public int updateOrderStatus(String status,int p_id,int c_id) throws BusinessException;
	
	public int updateOrderStatus(String status,int order_id) throws BusinessException;
}
