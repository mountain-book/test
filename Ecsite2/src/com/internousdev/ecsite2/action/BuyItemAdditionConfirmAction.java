package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAdditionConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String buyItemName;
	private String buyItemPrice;
	private String buyItemStock;
	private String errorMessage;

	public String execute() {
		String result = SUCCESS;
		if(!(buyItemName.equals(""))
			&& !(buyItemPrice.equals(""))
			&& !(buyItemStock.equals(""))) {
			session.put("buyItemName",buyItemName);
			session.put("buyItemPrice",buyItemPrice);
			session.put("buyItemStock",buyItemStock);
		}else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}

		return result;
	}

	public String getBuyItemName() {return buyItemName;}
	public void setBuyItemName(String buyItemName) {this.buyItemName=buyItemName;}

	public String getBuyItemPrice() {return buyItemPrice;}
	public void setBuyItemPrice(String buyItemPrice) {this.buyItemPrice=buyItemPrice;}

	public String getBuyItemStock() {return buyItemStock;}
	public void setBuyItemStock(String buyItemStock) {this.buyItemStock=buyItemStock;}

	public String getErrorMessage() {return errorMessage;}
	public void setErrorMessage(String errorMessage) {this.errorMessage=errorMessage;}

	@Override
	public void setSession(Map<String,Object>session) {this.session=session;}
}
