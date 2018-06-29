package com.internousdev.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.challenge.util.DBConnector;

public class ResetEmailDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private String sql = "UPDATE user_info SET email=? WHERE email=?";
	public void updateEmail(String newEmail, String oldEmail) {
	try {
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, newEmail);
	ps.setString(2, oldEmail);
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