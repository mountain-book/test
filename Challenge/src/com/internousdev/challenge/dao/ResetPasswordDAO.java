package com.internousdev.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.challenge.util.DBConnector;

public class ResetPasswordDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private String sql = "UPDATE user_info SET password=? WHERE password=?";
	public void updatePassword(String newPassword,String oldPassword) {
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newPassword);
		ps.setString(2, oldPassword);
		ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
