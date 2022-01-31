package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Customer> viewCustomers() {
		Connection conn = DButil.getConnection();
		List<Customer> customerList = new ArrayList<Customer>();

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM Customer");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				customerList.add(customer);
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return customerList;
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

			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}
}
