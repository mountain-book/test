package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.UserEditDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class UserEditDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	// ユーザー情報を取得するメソッド
	public ArrayList<UserEditDTO> getUserInfo()throws SQLException{
		ArrayList<UserEditDTO> userEditDTO = new ArrayList<UserEditDTO>();

		String sql =
				"SELECT id, login_id, login_pass, "
				+ "user_name, insert_date, updated_date "
				+ "FROM login_user_transaction "
				+ "ORDER BY id DESC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			// 対象のユーザー情報をすべて取得する
			while(rs.next()) {
				UserEditDTO dto = new UserEditDTO();
				dto.setId(rs.getInt("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdated_date(rs.getString("updated_date"));
				userEditDTO.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return userEditDTO;
	}

	public int UserDelete() throws SQLException{
		String sql =
				"DELETE FROM login_user_transaction";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result;
	}
}
