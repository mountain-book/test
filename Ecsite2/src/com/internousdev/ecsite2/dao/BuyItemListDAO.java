package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.BuyItemListDTO;
import com.internousdev.ecsite2.util.DBConnector;


public class BuyItemListDAO {
	private DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public ArrayList<BuyItemListDTO> getBuyItemCatalog() throws SQLException{
		ArrayList<BuyItemListDTO> buyItemListDTO = new ArrayList<BuyItemListDTO>();
		String sql =
				"SELECT item_name,item_price "
				+ "FROM item_info_transaction ";

	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			BuyItemListDTO dto = new BuyItemListDTO();
			dto.setItemName(rs.getString("item_name"));
			dto.setItemPrice(rs.getString("item_price"));
			buyItemListDTO.add(dto);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
	con.close();
	}
	return buyItemListDTO;
	}
}
