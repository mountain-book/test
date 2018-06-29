// ログイン情報をデータベースから取得する

package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class LoginDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword) {
		//login_user_transactionのlogin_idとlogin_passに代入するsql文
		String sql = "SELECT * FROM login_user_transaction WHERE login_id = ? AND login_pass = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs = ps.executeQuery();

			// もしResultSet(sql)のテーブルに一つでも要素があるならば(要素名の次のカラムがあるか確認している）
			if(rs.next()) {
				// ResultSetの情報で置き換える
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPass(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));

				// もしlogin_idがnullじゃなければ
				if(!(rs.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginDTO;

		}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

}
