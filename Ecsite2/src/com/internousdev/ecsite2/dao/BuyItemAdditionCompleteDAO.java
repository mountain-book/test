package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class BuyItemAdditionCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil du = new DateUtil();

	private String sql =
			"INSERT INTO item_info_transaction"
			+ "(item_name,item_price,item_stock,insert_date) "
			+ "VALUES(?,?,?,?)";

	public void buyItemAddition(
			String buyItemName,
			String buyItemPrice,
			String buyItemStock)
					throws SQLException{
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, buyItemName);
		ps.setString(2, buyItemPrice);
		ps.setString(3, buyItemStock);
		ps.setString(4, du.getDate());

		ps.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con.close();
			}
		}
}
