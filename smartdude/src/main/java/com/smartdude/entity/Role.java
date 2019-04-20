package com.smartdude.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer role_id;
	
	@Column(name="rolecode")
	private String roleCode;
	
	/*
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "userID")
	 * 
	 * @JsonIgnoreProperties private User user;
	 */

	public String getRole() {
		return roleCode;
	}

	/*
	 * public User getUsers() { return user; }
	 * 
	 * public void setUsers(User users) { this.user = users; }
	 */

	public Integer getRoleId() {
		return role_id;
	}

	public void setRoleId(Integer roleId) {
		this.role_id = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public void setRole(String roleCode) {
		this.roleCode = roleCode;
	}

}
