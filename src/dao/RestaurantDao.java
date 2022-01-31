package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DButil;
import pojo.Restaurant;

public class RestaurantDao {

	public boolean getRestaurant(Restaurant restaurant) {
		boolean status = false;
		Connection conn = DButil.getConnection();

		try {
			PreparedStatement pst = conn
					.prepareStatement("SELECT * from Restaurant where restaurantId = ? AND password = ?");
			pst.setInt(1, restaurant.getRestaurantId());
			pst.setString(2, restaurant.getPassword());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				status = true;

				restaurant.setName(rs.getString(3));
				restaurant.setEmail(rs.getString(4));
				restaurant.setPhoneNo(rs.getString(5));
				restaurant.setAddress(rs.getString(6));
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status;
	}

	public void getRestaurantName(Restaurant restaurant) {
		Connection conn = DButil.getConnection();

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * from Restaurant where restaurantId = ?");
			pst.setInt(1, restaurant.getRestaurantId());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				restaurant.setName(rs.getString(3));
				restaurant.setEmail(rs.getString(4));
				restaurant.setPhoneNo(rs.getString(5));
				restaurant.setAddress(rs.getString(6));
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

	}

	public List<Restaurant> viewRestaurants() {

		Connection conn = DButil.getConnection();
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * from Restaurant");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Restaurant restaurant = new Restaurant(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				restaurantList.add(restaurant);
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return restaurantList;
	}

	public boolean addRestaurant(Restaurant restaurant) {
		Connection conn = DButil.getConnection();

		int status = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("INSERT into Restaurant values (?, ?, ?, ?, ?, ?)");
			pst.setInt(1, restaurant.getRestaurantId());
			pst.setString(2, restaurant.getPassword());
			pst.setString(3, restaurant.getName());
			pst.setString(4, restaurant.getEmail());
			pst.setString(5, restaurant.getPhoneNo());
			pst.setString(6, restaurant.getAddress());

			System.out.println(pst);
			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}

	public boolean updateRestaurantAddress(int restaurantId, String address) {
		Connection conn = DButil.getConnection();

		int status = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE Restaurant SET address = ? WHERE restaurantId = ?");
			pst.setString(1, address);
			pst.setInt(2, restaurantId);

			System.out.println(pst);
			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}

	public boolean deleteRestaurant(int restaurantId) {
		Connection conn = DButil.getConnection();

		int status = 0;

		try {
			PreparedStatement pst = conn.prepareStatement("DELETE from Restaurant WHERE restaurantId = ?");
			pst.setInt(1, restaurantId);

			System.out.println(pst);
			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}
}
