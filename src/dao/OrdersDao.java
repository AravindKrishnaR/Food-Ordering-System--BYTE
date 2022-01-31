package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DButil;
import pojo.Orders;

public class OrdersDao {

	public boolean placeOrder(Orders order) {

		Connection conn = DButil.getConnection();

		int status = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("INSERT into Orders values (?, ?, ?)");
			pst.setString(1, order.getCustomerUsername());
			pst.setInt(2, order.getRestaurantId());
			pst.setInt(3, order.getFoodId());

			System.out.println(pst);
			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}

	public List<Orders> viewCustomerOrders(String customerUsername) {
		Connection conn = DButil.getConnection();
		List<Orders> orderList = new ArrayList<Orders>();

		try {
			PreparedStatement pst = conn.prepareStatement(
					"SELECT Orders.customerUsername, Customer.name, Orders.restaurantId, Restaurant.name, Orders.foodId, Food.name, Food.price FROM Orders "
							+ " JOIN Food ON Orders.foodId = Food.foodId"
							+ " JOIN Restaurant ON Orders.restaurantId = Restaurant.restaurantId"
							+ " JOIN Customer ON Orders.customerUsername = Customer.username"
							+ " WHERE Customer.username = ?");
			pst.setString(1, customerUsername);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Orders order = new Orders(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getDouble(7));
				orderList.add(order);
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return orderList;
	}

	public List<Orders> viewRestaurantOrders(int restaurantId) {
		Connection conn = DButil.getConnection();
		List<Orders> orderList = new ArrayList<Orders>();

		try {
			PreparedStatement pst = conn.prepareStatement(
					"SELECT Orders.customerUsername, Customer.name, Orders.restaurantId, Restaurant.name, Orders.foodId, Food.name, Food.price FROM Orders"
							+ " JOIN Food ON Orders.foodId = Food.foodId"
							+ " JOIN Restaurant ON Orders.restaurantId = Restaurant.restaurantId"
							+ " JOIN Customer ON Orders.customerUsername = Customer.username"
							+ " WHERE Restaurant.restaurantId = ?");
			pst.setInt(1, restaurantId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Orders order = new Orders(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getDouble(7));
				orderList.add(order);
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return orderList;
	}

}
