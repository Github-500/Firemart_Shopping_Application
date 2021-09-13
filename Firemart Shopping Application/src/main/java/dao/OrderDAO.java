package com.application.dao;

import java.util.List;

import com.application.exception.BusinessException;
import com.application.model.Order;

public interface OrderDAO {

	public int placeOrder(int customer_id) throws BusinessException;

	public List<Order> getAllOrders(int customer_id) throws BusinessException;

	public int updateOrderStatus(String status, int p_id,int c_id) throws BusinessException;

	public int updateOrderStatus(String status,int order_id) throws BusinessException;

}
