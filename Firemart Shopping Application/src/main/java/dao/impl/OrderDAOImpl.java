package com.application.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.application.dao.OrderDAO;
import com.application.dao.dbutil.MySqlDbConnection;
import com.application.exception.BusinessException;
import com.application.model.Cart;
import com.application.model.Order;

public class OrderDAOImpl implements OrderDAO{
	
	private static Logger log = Logger.getLogger(CustomerLoginDAOImpl.class);

	@Override
	public int placeOrder(int customer_id) throws BusinessException {
		int c=0;
		double total=0.0;
		String order_status="ordered";
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql1 = "select id,customer_id,name,totalprice from cart where customer_id=?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, customer_id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			while(resultSet.next()) {
			Cart cart=new Cart();
			cart.setC_id(resultSet.getInt("id"));
			cart.setCustomer_id(resultSet.getInt("customer_id"));
			cart.setC_name(resultSet.getString("name"));
			cart.setC_price(resultSet.getDouble("totalprice"));
			total+=cart.getC_price();
			c=insertProduct(cart,order_status);
			}
			log.info("total cart value "+total);
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

	private int insertProduct(Cart cart,String order_status) throws BusinessException {		
		int c=0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
		String sql = "insert into orders(customer_id,product_id,product_name,product_price,order_status) values(?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, cart.getCustomer_id());
		preparedStatement.setInt(2, cart.getC_id());
		preparedStatement.setString(3, cart.getC_name());
		preparedStatement.setDouble(4, cart.getC_price());
		preparedStatement.setString(5, order_status);
		c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

	@Override
	public List<Order> getAllOrders(int customer_id) throws BusinessException {
		List<Order> orderList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select order_id,customer_id,product_id,product_name,product_price,order_status from orders where customer_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order order = new Order();
				order.setOrder_id(resultSet.getInt("order_id"));
				order.setCustomer_id(resultSet.getInt("Customer_id"));
				order.setProduct_id(resultSet.getInt("product_id"));
				order.setProduct_name(resultSet.getString("product_name"));
				order.setProduct_price(resultSet.getDouble("product_price"));
				order.setOrder_status(resultSet.getString("order_status"));
				orderList.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
	         log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}

		return orderList;
	}

	@Override
	public int updateOrderStatus(String status, int p_id,int c_id) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "update orders set order_status=? where product_id=? and customer_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, p_id);
			preparedStatement.setInt(3, c_id);

			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

	@Override
	public int updateOrderStatus(String status,int order_id) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "update orders set order_status=? where order_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, order_id);

			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}	

}


