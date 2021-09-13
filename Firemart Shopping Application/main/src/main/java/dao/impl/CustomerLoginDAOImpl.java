package com.application.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.application.dao.CustomerLoginDAO;
import com.application.dao.dbutil.MySqlDbConnection;
import com.application.exception.BusinessException;
import com.application.model.Product;

public class CustomerLoginDAOImpl implements CustomerLoginDAO {
	private static Logger log = Logger.getLogger(CustomerLoginDAOImpl.class);
	@Override
	public int validCustomer(String email, String password) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id,name,password from customers where email=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			if(resultSet.getString("password").equals(password)){
				log.info("Customer Login successful");
				log.info("Welcome "+resultSet.getString("name"));
				c=resultSet.getInt("id");
			}else {
				log.info("password not correct");
			}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}
	
	@Override
	public List<Product> getAllProducts() throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id,name,price from products order by id";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setP_id(resultSet.getInt("id"));
				product.setP_name(resultSet.getString("name"));
				product.setP_price(resultSet.getInt("price"));
				productList.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
	         log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}

		return productList;
	}

	@Override
	public Product getProductById(int id) throws BusinessException {
		Product product = null;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id,name,price from products where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				product = new Product();
				product.setP_id(resultSet.getInt("id"));
				product.setP_name(resultSet.getString("name"));
				product.setP_price(resultSet.getDouble("price"));
			} else {
				throw new BusinessException("Entered product id " + id + " doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact system admin");
		}
		return product;
	}

	@Override
	public Product getProductByName(String name) throws BusinessException {
  
		Product product = null;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id,name,price from products where name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				product = new Product();
				product.setP_id(resultSet.getInt("id"));
				product.setP_name(resultSet.getString("name"));
				product.setP_price(resultSet.getDouble("price"));
			} else {
				throw new BusinessException("Entered product name " + name + " doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact system admin");
		}
		return product;
	}



}
