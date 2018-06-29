package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.MyPageDAO;
import com.internousdev.ecsite2.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private MyPageDAO dao = new MyPageDAO();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		String result = SUCCESS;
		
		// もしセッションにidの情報がない場合
		if(!session.containsKey("id")) {
			result = ERROR;
		}
		// 削除ボタンを押していない場合
		if(deleteFlg == null) {
			// idとログインユーザーの情報を取得
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();
			// 購入履歴情報をデータベースから取得(詳細はDAOファイルに記載)
			myPageList = dao.getMyPageUserInfo(item_transaction_id, user_master_id);
		// 削除ボタンを押した場合
		}else if(deleteFlg.equals("1")) {
			// deleteメソッドを実行(以下にて実装)
			delete();
		}
		
		return result;
	}
	// 購入履歴を削除するためのメソッド
	public void delete() throws SQLException{
		// idとユーザーの情報を取得
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		// データベースから購入履歴情報を削除し、残りがないか確かめる(詳細はDAOファイルに記載)
		int res = dao.buyItemHistoryDelete(item_transaction_id, user_master_id);

		// ひとつでも削除が実行された場合
		if(res > 0) {
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		// ひとつも削除されなかった場合
		}else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public ArrayList<MyPageDTO> getMyPageList(){
		return myPageList;
	}
	public void setMyPageList(ArrayList<MyPageDTO> myPageList) {
		this.myPageList=myPageList;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg=deleteFlg;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message=message;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
