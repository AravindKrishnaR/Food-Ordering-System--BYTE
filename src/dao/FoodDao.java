package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DButil;
import pojo.Food;
import pojo.Restaurant;

public class FoodDao {

	public static boolean addFood(Restaurant restaurant, Food food) {

		Connection conn = DButil.getConnection();

		int status = 0;

		try {
			PreparedStatement pst = conn.prepareStatement(
					"INSERT into Food(restaurantId, name, description, price, category) values (?, ?, ?, ?, ?)");
			pst.setInt(1, restaurant.getRestaurantId());
			pst.setString(2, food.getName());
			pst.setString(3, food.getDescription());
			pst.setDouble(4, food.getPrice());
			pst.setString(5, food.getCategory());

			System.out.println(pst);
			status = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status > 0 ? true : false;
	}
	
	public List<String> viewCategory() {
		
		Connection conn = DButil.getConnection();
		List<String> categoryList = new ArrayList<>();
		
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT distinct category from Food");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				categoryList.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);
		
		return categoryList;
	}

	public List<Food> viewFoodMenuByRestaurant(int restaurantId) {

		Connection conn = DButil.getConnection();
		List<Food> foodMenu = new ArrayList<Food>();

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * from Food where restaurantId = ?");
			pst.setInt(1, restaurantId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Food food = new Food(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getString(6));
				foodMenu.add(food);
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return foodMenu;
	}

	public List<Food> viewFoodMenuByCategory(String categoryChoice) {

		Connection conn = DButil.getConnection();
		List<Food> foodMenu = new ArrayList<Food>();

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * from Food where category = ?");
			pst.setString(1, categoryChoice);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Food food = new Food(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getString(6));
				foodMenu.add(food);
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return foodMenu;
	}

}
