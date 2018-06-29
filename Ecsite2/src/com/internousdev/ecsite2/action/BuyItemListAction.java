package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dao.BuyItemListDAO;
import com.internousdev.ecsite2.dto.BuyItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemListAction extends ActionSupport{
	private BuyItemListDAO dao = new BuyItemListDAO();
	private ArrayList<BuyItemListDTO> buyItemCatalog = new ArrayList<BuyItemListDTO>();

	public String execute() throws SQLException {
		buyItemCatalog = dao.getBuyItemCatalog();
		return SUCCESS;
	}

}
