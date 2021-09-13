package com.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.application.dao.CustomerRegistrationDAO;
import com.application.dao.dbutil.MySqlDbConnection;
import com.application.exception.BusinessException;
import com.application.model.Customer;

public class CustomerRegistrationDAOImpl implements CustomerRegistrationDAO  {

	private static Logger log = Logger.getLogger(CustomerRegistrationDAOImpl.class);
	
	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into customers(id,name,email,password,contact,gender,address) values(?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setLong(5, customer.getContact());
			preparedStatement.setString(6, customer.getGender());
			preparedStatement.setString(7, customer.getAddress());

			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

}
