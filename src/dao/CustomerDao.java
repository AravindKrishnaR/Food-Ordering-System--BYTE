package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DButil;
import pojo.Customer;

public class CustomerDao {

	public boolean getCustomer(Customer customer) {
		boolean status = false;
		Connection conn = DButil.getConnection();

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * from Customer where username = ? AND password = ?");
			pst.setString(1, customer.getUsername());
			pst.setString(2, customer.getPassword());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				status = true;
				
				customer.setName(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setPhoneNo(rs.getString(5));
				customer.setAddress(rs.getString(6));
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status;
	}

	public boolean addCustomer(Customer customer) {

		Connection conn = DButil.getConnection();

		int status = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("INSERT into Customer values (?, ?, ?, ?, ?, ?)");
			pst.setString(1, customer.getUsername());
			pst.setString(2, customer.getPassword());
			pst.setString(3, customer.getName());
			pst.setString(4, customer.getEmail());
			pst.setString(5, customer.getPhoneNo());
			pst.setString(6, customer.getAddress());

			System.out.println(pst);
			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}

	public boolean updateCustomerAddress(String username, String address) {

		Connection conn = DButil.getConnection();

		int status = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE Customer SET address = ? WHERE username = ?");
			pst.setString(1, address);
			pst.setString(2, username);

			System.out.println(pst);
			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}

	public boolean deleteCustomer(String username) {

		Connection conn = DButil.getConnection();

		int status = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("DELETE from Customer WHERE username = ?");
			pst.setString(1, username);

			System.out.println(pst);
			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}
}
