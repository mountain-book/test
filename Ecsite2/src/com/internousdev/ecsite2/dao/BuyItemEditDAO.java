package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.BuyItemEditDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class BuyItemEditDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<BuyItemEditDTO> getBuyItemInfo() throws SQLException{
		ArrayList<BuyItemEditDTO> buyItemEditDTO = new ArrayList<BuyItemEditDTO>();

		String sql =
				"SELECT item_name, item_price, item_stock, "
				+ "insert_date, update_date "
				+ "FROM item_info_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				BuyItemEditDTO dto = new BuyItemEditDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdated_date(rs.getString("update_date"));
				buyItemEditDTO.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return buyItemEditDTO;
	}

	public int buyItemDelete() throws SQLException{
		String sql = "DELETE FROM item_info_transaction";
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
