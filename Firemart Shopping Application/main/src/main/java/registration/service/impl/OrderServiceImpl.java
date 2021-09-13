package com.application.registration.service.impl;

import java.util.List;


import com.application.dao.OrderDAO;
import com.application.dao.impl.OrderDAOImpl;
import com.application.exception.BusinessException;
import com.application.model.Order;
import com.application.registration.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private OrderDAO orderDAO = new OrderDAOImpl();
	
	@Override
	public int placeOrder(int customer_id) throws BusinessException {
		int c=0;
		c=orderDAO.placeOrder(customer_id);
		return c;
	}

	@Override
	public List<Order> getAllOrders(int customer_id) throws BusinessException {
		List<Order>  orderList= null;
		orderList = orderDAO.getAllOrders(customer_id);
		return orderList;
	}

	@Override
	public int updateOrderStatus(String status, int p_id,int c_id) throws BusinessException {
		int c=0;
		c=orderDAO.updateOrderStatus(status,p_id,c_id);
		return c;
	}

	@Override
	public int updateOrderStatus(String status,int order_id) throws BusinessException {
		int c=0;
		c=orderDAO.updateOrderStatus(status,order_id);
		return c;
	}

}
