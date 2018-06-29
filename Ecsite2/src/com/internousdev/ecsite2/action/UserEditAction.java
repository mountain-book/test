package com.internousdev.ecsite2.action;


import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dao.UserEditDAO;
import com.internousdev.ecsite2.dto.UserEditDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserEditAction extends ActionSupport{
	private ArrayList<UserEditDTO> userList = new ArrayList<UserEditDTO>();
	private UserEditDAO dao = new UserEditDAO();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		String result = SUCCESS;

		if(deleteFlg == null) {
			userList = dao.getUserInfo();
		}else if(deleteFlg.equals("1")) {
			delete();
		}
		return result;
	}

	public void delete() throws SQLException{
		int res = dao.UserDelete();
		if(res > 0) {
			userList = null;
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res == 0) {
			setMessage("ユーザー情報の削除に失敗しました。");
		}
	}

	public ArrayList<UserEditDTO> getUserList(){
		return userList;
	}
	public void setUserId(ArrayList<UserEditDTO> userList) {
		this.userList=userList;
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
}
