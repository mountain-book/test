package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dao.BuyItemEditDAO;
import com.internousdev.ecsite2.dto.BuyItemEditDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemEditAction extends ActionSupport{
	private ArrayList<BuyItemEditDTO> buyItemList = new ArrayList<BuyItemEditDTO>();
	private BuyItemEditDAO dao = new BuyItemEditDAO();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		String result = SUCCESS;
		/*if(!session.containsKey("id")) {
			result = ERROR;
		}*/
		if(deleteFlg == null) {
		buyItemList = dao.getBuyItemInfo();
		}else if(deleteFlg.equals("1")) {
			delete();
		}
		return result;
	}

	public void delete() throws SQLException{
		int res = dao.buyItemDelete();
		if(res > 0) {
			buyItemList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public ArrayList<BuyItemEditDTO> getBuyItemList(){return buyItemList;}
	public void setBuyItemList(ArrayList<BuyItemEditDTO> buyItemList) {this.buyItemList=buyItemList;}

	public String getDeleteFlg() {return deleteFlg;}
	public void setDeleteFlg(String deleteFlg) {this.deleteFlg=deleteFlg;}

	public String getMessage() {return message;}
	public void setMessage(String message) {this.message=message;}
}
