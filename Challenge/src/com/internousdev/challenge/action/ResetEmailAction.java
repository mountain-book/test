package com.internousdev.challenge.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.challenge.dao.ResetEmailDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetEmailAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String oldEmail;
	private String newEmail;
	private String checkEmail;
	private String nullMessage;
	private String differenceMessage;

	public String execute() {
		String result = ERROR;
		oldEmail = session.get("Email").toString();
		if(!(oldEmail.equals(""))
			&& !(newEmail.equals(""))
			&& !(checkEmail.equals(""))
			&& newEmail.equals(checkEmail)) {
		ResetEmailDAO dao = new ResetEmailDAO();
		dao.updateEmail(newEmail, oldEmail);
		session.put("Email", newEmail);
		result = SUCCESS;
		}
		if(newEmail.equals("") || checkEmail.equals("")) {
			setNullMessage("未入力の項目があります。");
		}
		if(!(newEmail.equals(checkEmail))) {
			setDifferenceMessage("「新しいメールアドレス」と「確認用メールアドレス」を一致させて下さい。");
		}
		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

	public String getoldEmail() {
		return oldEmail;
	}
	public void setOlidEmail(String oldEmail) {
		this.oldEmail=oldEmail;
	}

	public String getNewEmail() {
		return newEmail;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail=newEmail;
	}

	public String getCheckEmail() {
		return checkEmail;
	}
	public void setCheckEmail(String checkEmail) {
		this.checkEmail=checkEmail;
	}

	public String getNullMessage() {
		return nullMessage;
	}
	public void setNullMessage(String nullMessage) {
		this.nullMessage=nullMessage;
	}

	public String getDifferenceMessage() {
		return differenceMessage;
	}
	public void setDifferenceMessage(String differenceMessage) {
		this.differenceMessage=differenceMessage;
	}
}
