package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DButil;
import pojo.Admin;

public class AdminDao {

	public boolean getAdmin(Admin admin) {

		boolean status = false;
		Connection conn = DButil.getConnection();

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * from Admin where username = ? AND password = ?");
			pst.setString(1, admin.getUsername());
			pst.setString(2, admin.getPassword());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				status = true;
				
				admin.setName(rs.getString(3));
				admin.setEmail(rs.getString(4));
				admin.setPhoneNo(rs.getString(5));
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}

		DButil.closeConnection(conn);

		return status;
	}

}
