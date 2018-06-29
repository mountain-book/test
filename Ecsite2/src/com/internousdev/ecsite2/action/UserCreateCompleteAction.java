package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private UserCreateCompleteDAO uccDAO = new UserCreateCompleteDAO();

	public String execute() throws SQLException{
	uccDAO.createUser(
			session.get("loginUserId").toString(),
			session.get("loginPassword").toString(),
			session.get("userName").toString());

	String result = SUCCESS;
	return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
}
