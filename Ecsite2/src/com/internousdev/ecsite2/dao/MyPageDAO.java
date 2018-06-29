package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.MyPageDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class MyPageDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	// 購入履歴の情報を取得するメソッド
	public ArrayList<MyPageDTO> getMyPageUserInfo
		(String item_transaction_id,String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		/*
		 *  SELECT ### 		：###(フィールド)を選択
		 *  FROM ###		：###(テーブル)から
		 *  LEFT JOIN ###	：###(テーブル)を左結合
		 *  ON ###			：###(フィールド)を共通項として
		 *  WHERE ###		：###(フィールド)について
		 *  AND ###			：###(フィールド)を上記に追加
		 *  ORDER BY ###	：###(フィールド)を~で並び替え
		 *  購入日降順で、ログインしたユーザーが購入した商品の
		 *  id、名前、値段、個数、支払い方法、購入日の情報を取得
		 */
		String sql =
				"SELECT ubit.id, iit.item_name, ubit.total_price, "
				+ "ubit.total_count, ubit.pay, ubit.insert_date "
				+ "FROM user_buy_item_transaction ubit "
				+ "LEFT JOIN item_info_transaction iit "
				+ "ON ubit.item_transaction_id = iit.id "
				+ "WHERE ubit.item_transaction_id = ? "
				+ "AND ubit.user_master_id = ? "
				+ "ORDER BY insert_date DESC";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs =  ps.executeQuery();

			// 対象の購入品のデータをすべて取得する
			while(rs.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return myPageDTO;
	}

	// 購入履歴を削除するメソッド
	public int buyItemHistoryDelete
		(String item_transaction_id,String user_master_id) throws SQLException{
		// ログイン中のユーザーの購入履歴を削除(ほかの人のは削除しない)
		String sql =
				"DELETE FROM user_buy_item_transaction "
				+ "WHERE item_transaction_id = ? "
				+ "AND user_master_id = ?";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result;
	}
}
