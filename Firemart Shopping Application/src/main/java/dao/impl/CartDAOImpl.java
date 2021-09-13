package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.application.dao.CartDAO;
import com.application.dao.dbutil.MySqlDbConnection;
import com.application.exception.BusinessException;
import com.application.model.Cart;
import com.application.model.Product;

public class CartDAOImpl implements CartDAO{
	private static Logger log = Logger.getLogger(CustomerLoginDAOImpl.class);
	
	
	@Override
	public List<Cart> getCartProducts(int customer_id) throws BusinessException {
		List<Cart> cartList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id,customer_id,name,totalprice from cart where customer_id=? order by id";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cart cart = new Cart();
				cart.setC_id(resultSet.getInt("id"));
				cart.setCustomer_id(resultSet.getInt("customer_id"));
				cart.setC_name(resultSet.getString("name"));
				cart.setC_price(resultSet.getInt("totalprice"));
				cartList.add(cart);
			}
		} catch (ClassNotFoundException | SQLException e) {
	         log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}

		return cartList;
	}
	
	@Override
	public int addCartProduct(int id,int customer_id) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into cart(id,customer_id,name,totalprice) values(?,?,?,?)";
			String sql1 = "select id,name,price from products where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			if(resultSet.next()) {
			Product product=new Product();
			product.setP_id(resultSet.getInt("id"));
			product.setP_name(resultSet.getString("name"));
			product.setP_price(resultSet.getDouble("price"));
			preparedStatement.setInt(1, product.getP_id());
			preparedStatement.setInt(2, customer_id);
			preparedStatement.setString(3, product.getP_name());
			preparedStatement.setDouble(4, product.getP_price());
			}
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

	@Override
	public int deleteCartProduct(int id,int cust_id) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "DELETE FROM cart WHERE id=? and customer_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, cust_id);
			
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

	@Override
	public int emptyCart(int customer_id) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "delete from cart where customer_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

}
