package com.internousdev.challenge.dto;

public class GoMyPageDTO {
	private String familyName;
	private String firstName;
	private String sex;
	private String Email;

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

}
