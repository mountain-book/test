package com.internousdev.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.challenge.dto.GoMyPageDTO;
import com.internousdev.challenge.util.DBConnector;

public class GoMyPageDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();


	public GoMyPageDTO getMyPageInfo(String userId, String password) {
		GoMyPageDTO dto = new GoMyPageDTO();
		String sql = "SELECT user_id, password, family_name, first_name, sex, email "
				+ "FROM user_info "
				+ "WHERE user_id=? AND password=?";
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			dto.setFamilyName(rs.getString("family_name"));
			dto.setFirstName(rs.getString("first_name"));
			dto.setSex(rs.getString("sex"));
			dto.setEmail(rs.getString("email"));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return dto;
	}
}
