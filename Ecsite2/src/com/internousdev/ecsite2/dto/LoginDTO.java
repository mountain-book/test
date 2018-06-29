package com.internousdev.ecsite2.dto;

public class LoginDTO {
	private String loginId;
	private String loginPass;
	private String userName;
	private boolean loginFlg = false;

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId=loginId;
	}

	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass=loginPass;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg=loginFlg;
	}
}
