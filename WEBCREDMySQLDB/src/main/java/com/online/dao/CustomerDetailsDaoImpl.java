package com.online.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.online.model.CustomerDetails;
import com.online.util.JdbcUtil;




public class CustomerDetailsDaoImpl implements IsCustomerDetailsDao {
	Connection connection = null;

	@Override
	public String save(CustomerDetails custDetails) {
		String sqlInsertQuery = "INSERT INTO customer_details (`customer_name`, `customer_age`, `customer_address`) VALUES (?,?,?)";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = JdbcUtil.physicalConnection();
			pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, custDetails.getCustomerName());
				pstmt.setInt(2, custDetails.getCustomerAge());
				pstmt.setString(3, custDetails.getCustomerAddress());
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (IOException ex) {
			status = "failure";
			ex.printStackTrace();
		} catch (SQLException e) {
			status = "failure";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String update(CustomerDetails custDetails) {

		String sqlInsertQuery = "UPDATE customer_details SET customer_name=?,customer_age=?,customer_address=? where customer_no=?";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = JdbcUtil.physicalConnection();
			pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, custDetails.getCustomerName());
				pstmt.setInt(2, custDetails.getCustomerAge());
				pstmt.setString(3, custDetails.getCustomerAddress());
				pstmt.setInt(4, custDetails.getCustomerNo());
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (IOException ex) {
			status = "failure";
			ex.printStackTrace();
		} catch (SQLException e) {
			status = "failure";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(int id) {



		String sqlDeleteQuery = "delete from customer_details where customer_no = ? ";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			CustomerDetails custmer = search(id);
			if (custmer != null) {

				connection = JdbcUtil.physicalConnection();
				if (connection != null)
					pstmt = connection.prepareStatement(sqlDeleteQuery);
				if (pstmt != null)
					pstmt.setInt(1, id);

				if (pstmt != null) {
					int rowAffected = pstmt.executeUpdate();
					if (rowAffected == 1)
						status = "success";
				}
			} else {
				status = "not available";
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	
	}

	@Override
	public CustomerDetails search(int id) {


		String sqlSelectQuery = "select customer_no, customer_name, customer_age, customer_address from customer_details where customer_no=?";
		PreparedStatement pstmt = null;
		CustomerDetails customer = null;
		try {
			connection = JdbcUtil.physicalConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			if (pstmt != null) {
				pstmt.setInt(1, id);
			}
			if (pstmt != null) {
				ResultSet resultSet = pstmt.executeQuery();

				if (resultSet.next()) {
					// copy the reusltSet data to StudentDTO and trasfer to the view
					customer = new CustomerDetails();

					customer.setCustomerNo(resultSet.getInt(1));
					customer.setCustomerName(resultSet.getString(2));
					customer.setCustomerAge(resultSet.getInt(3));
					customer.setCustomerAddress(resultSet.getString(4));
	
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return customer;
	
	}

}
