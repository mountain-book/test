package com.internousdev.challenge.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.challenge.dao.LoginDAO;
import com.internousdev.challenge.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String userId;
	private String password;
	private String errorMessage;
	private Map<String,Object> session;
	private LoginDAO dao = new LoginDAO();
	private LoginDTO dto = new LoginDTO();
	public String execute() {
		String result = ERROR;
		dto = dao.getLoginUserInfo(userId, password);

		if(dto.getLoginFlg()) {
			session.put("userId", userId);
			session.put("password", password);
			result = SUCCESS;
		}else {
			setErrorMessage("ユーザーIDまたはパスワードが違います。");
		}
		return result;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}

	public String getpassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
}
