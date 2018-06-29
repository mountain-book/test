// 購入品の情報を取得するクラス

package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class BuyItemDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public ArrayList<BuyItemDTO> getBuyItemInfo() {
		ArrayList<BuyItemDTO> biDTO = new ArrayList<BuyItemDTO>();
		String sql = "SELECT id,item_name,item_price FROM item_info_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("itemName"));
				buyItemDTO.setItemPrice(rs.getString("itemPrice"));
				biDTO.add(buyItemDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return biDTO;
	}

	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}
}
