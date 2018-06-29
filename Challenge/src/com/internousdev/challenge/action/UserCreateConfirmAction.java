package com.internousdev.challenge.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.challenge.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private UserCreateConfirmDAO dao = new UserCreateConfirmDAO();
	public String execute() throws SQLException{
		dao.createUser(
				session.get("userId").toString(),
				session.get("password").toString(),
				session.get("familyName").toString(),
				session.get("firstName").toString(),
				session.get("familyName_kana").toString(),
				session.get("firstName_kana").toString(),
				session.get("sex").toString(),
				session.get("Email").toString());
		return SUCCESS;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
}
