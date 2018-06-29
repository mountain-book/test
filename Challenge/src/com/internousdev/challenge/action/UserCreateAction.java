package com.internousdev.challenge.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String familyName;
	private String firstName;
	private String familyName_kana;
	private String firstName_kana;
	private String sex;
	private String Email;
	private String userId;
	private String password;
	private String errorMessage;

	public String execute() {
		String result = SUCCESS;
		if(!(familyName.equals(""))
			&& !(firstName.equals(""))
			&& !(familyName_kana.equals(""))
			&& !(firstName_kana.equals(""))
			&& !(Email.equals(""))
			&& !(userId.equals(""))
			&& !(password.equals(""))) {
				session.put("familyName", familyName);
				session.put("firstName", firstName);
				session.put("familyName_kana", familyName_kana);
				session.put("firstName_kana", firstName_kana);
				session.put("sex", sex);
				session.put("Email", Email);
				session.put("userId", userId);
				session.put("password", password);
		}else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName=familyName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	public String getFamilyName_kana() {
		return familyName_kana;
	}
	public void setFamilyName_kana(String familyName_kana) {
		this.familyName_kana=familyName_kana;
	}

	public String getFirstName_kana() {
		return firstName_kana;
	}
	public void setFirstName_kana(String firstName_kana) {
		this.firstName_kana=firstName_kana;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}

	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email=Email;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session) {
		this.session=session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
}
