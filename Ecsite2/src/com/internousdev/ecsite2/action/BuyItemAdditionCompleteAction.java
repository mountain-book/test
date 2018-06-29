package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemAdditionCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAdditionCompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private BuyItemAdditionCompleteDAO biacDAO = new BuyItemAdditionCompleteDAO();

	public String execute() throws SQLException{
		biacDAO.buyItemAddition(
				session.get("buyItemName").toString(),
				session.get("buyItemPrice").toString(),
				session.get("buyItemStock").toString());

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String,Object>session) {this.session=session;}
}
