package com.internousdev.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.challenge.util.DBConnector;
import com.internousdev.challenge.util.DateUtil;

public class UserCreateConfirmDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil du = new DateUtil();

	private String sql = "INSERT INTO user_info("
			+ "user_id,password,family_name,"
			+ "first_name,family_name_kana,"
			+ "first_name_kana,sex,email,"
			+ "insert_date,update_date) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
	public void createUser(
			String userId, String password,
			String familyName, String firstName,
			String familyName_kana, String firstName_kana,
			String sex, String Email)
					throws SQLException {
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ps.setString(2, password);
		ps.setString(3, familyName);
		ps.setString(4, firstName);
		ps.setString(5, familyName_kana);
		ps.setString(6, firstName_kana);
		ps.setString(7,sex);
		ps.setString(8, Email);
		ps.setString(9, du.getDate());
		ps.setString(10, du.getDate());
		ps.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		con.close();
	}
}
}