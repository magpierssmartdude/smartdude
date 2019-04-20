package com.smartdude.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;

	@Column(name="username")
	private String userName;
	
	@Column(name="client_code")
	private String client_code;
	public User(User user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.client_code = user.getClientCode();
		this.roles = user.getRoles();
	}
public String getClientCode() {
		return client_code;
	}
	public void setClientCode(String clientCode) {
		this.client_code = clientCode;
	}
public User() {
	
}
@Column(name="password")
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userID", nullable = false)
	private List<Role> roles;

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
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
