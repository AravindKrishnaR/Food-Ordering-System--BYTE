package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

	public static Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodOrderingSystem", "root", "password");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {

		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
