package com.internousdev.ecsite.dto;

public class BuyItemDTO {
	//↓public ?????
	public int id;
	public String itemName;
	//↓String型でいいの？(int型では?)
	public String itemPrice;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice=itemPrice;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
}
