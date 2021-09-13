package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.application.dao.EmployeeLoginDAO;
import com.application.dao.dbutil.MySqlDbConnection;
import com.application.exception.BusinessException;
import com.application.model.Customer;
import com.application.model.Product;

public class EmployeeLoginDAOImpl implements EmployeeLoginDAO {

	private static Logger log = Logger.getLogger(CustomerRegistrationDAOImpl.class);
	
	@Override
	public List<Customer> getAllCustomers() throws BusinessException {

		List<Customer> customerList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select id,name,email,password,contact,gender,address from customers order by id";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setName(resultSet.getString("name"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customer.setContact(resultSet.getLong("contact"));
				customer.setGender(resultSet.getString("gender"));
				customer.setAddress(resultSet.getString("address"));
				customerList.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
	         log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}

		return customerList;
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
	public int addProduct(Product product) throws BusinessException {

		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into products(id,name,price) values(?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product.getP_id());
			preparedStatement.setString(2, product.getP_name());
			preparedStatement.setDouble(3, product.getP_price());

			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

	@Override
	public int deleteProduct(int id) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "DELETE FROM products WHERE id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

}
