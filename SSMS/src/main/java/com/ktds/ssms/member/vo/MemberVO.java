package com.ktds.ssms.member.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberVO {

	@NotEmpty(message = "필수 정보입니다.")
	private String id;
	
	@NotEmpty(message = "필수 정보입니다.")
	private String name;
	
	@NotEmpty(message = "필수 정보입니다.")
	private String birthday;
	
	@NotEmpty(message = "필수 정보입니다.")
	private String phoneNumber;
	
	@NotEmpty(message = "필수 정보입니다.")
	private String password;
	
	private String salt;
	
	private String isAdmin;
	
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
