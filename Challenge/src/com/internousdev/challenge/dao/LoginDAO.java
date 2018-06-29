package com.internousdev.challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.challenge.dto.LoginDTO;
import com.internousdev.challenge.util.DBConnector;

public class LoginDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private LoginDTO dto = new LoginDTO();
	
	public LoginDTO getLoginUserInfo(String userId, String password) {
		String sql = "SELECT * FROM user_info "
				+ "WHERE user_id=? AND password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setUserId(rs.getString("user_id"));
				dto.setPassword(rs.getString("password"));
			
				if(!(rs.getString("user_id").equals(null))
						&& !(rs.getString("password").equals(null))) {
					dto.setLoginFlg(true);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}	
}
