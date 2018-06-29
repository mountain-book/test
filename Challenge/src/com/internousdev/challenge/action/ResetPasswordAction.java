package com.internousdev.challenge.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.challenge.dao.ResetPasswordDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String oldPassword;
	private String newPassword;
	private String checkPassword;
	private String nullMessage;
	private String missMessage;
	private String differenceMessage;
	public String execute() {
		String result = ERROR;
		if(!(oldPassword.equals(""))
				&& !(newPassword.equals(""))
				&& !(checkPassword.equals(""))
				&& newPassword.equals(checkPassword)
				&& !(newPassword.equals(oldPassword))) {
			ResetPasswordDAO dao = new ResetPasswordDAO();
			dao.updatePassword(newPassword, oldPassword);
			session.put("password", newPassword);
			result = SUCCESS;
		}
		if(oldPassword.equals("") || newPassword.equals("") || checkPassword.equals("")){
			setNullMessage("未入力の項目があります。");
		}
		if(!(oldPassword.equals(session.get("password").toString()))){
			setMissMessage("「現在のパスワード」が違います。");
		}
		if(!(newPassword.equals(checkPassword))) {
			setDifferenceMessage("「新しいパスワード」と「確認用パスワード」を一致させて下さい。");
		}
		return result;
	}


	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword=oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword=newPassword;
	}

	public String getCheckPassword() {
		return checkPassword;
	}
	public void setCheckPassword(String checkPassword) {
		this.checkPassword=checkPassword;
	}

	public String getNullMessage() {
		return nullMessage;
	}
	public void setNullMessage(String nullMessage) {
		this.nullMessage=nullMessage;
	}

	public String getMissMessage() {
		return missMessage;
	}
	public void setMissMessage(String missMessage) {
		this.missMessage=missMessage;
	}

	public String getDifferenceMessage() {
		return differenceMessage;
	}
	public void setDifferenceMessage(String differenceMessage) {
		this.differenceMessage=differenceMessage;
	}

}
