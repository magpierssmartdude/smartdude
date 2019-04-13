package com.smartdude.entity;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

	@Indexed(unique=true)
	private String userName;
	
	public User(User user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.clinetCode = user.getClinetCode();
		this.roles = user.getRoles();
	}
public User() {
	
}
	private String password;
	
	public String getClinetCode() {
		return clinetCode;
	}

	public void setClinetCode(String clinetCode) {
		this.clinetCode = clinetCode;
	}

	private String clinetCode;
	
	private List<Role> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
