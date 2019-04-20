package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4088514319132260545L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vendorid;

	public Integer getVendorid() {
		return vendorid;
	}

	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String vendorcode;
	private String vendorname;
	private String organizationtype;
	private String organizationname;
	private String password;
	private String phonenumber;
	private LocalDateTime authendicatedtime;
	private LocalDateTime createdtimestamp;

	public LocalDateTime getAuthendicatedtime() {
		return authendicatedtime;
	}

	public void setAuthendicatedtime(LocalDateTime authendicatedtime) {
		this.authendicatedtime = authendicatedtime;
	}

	public LocalDateTime getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(LocalDateTime createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	public String getVendorcode() {
		return vendorcode;
	}

	public void setVendorcode(String vendorcode) {
		this.vendorcode = vendorcode;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getOrganizationtype() {
		return organizationtype;
	}

	public void setOrganizationtype(String organizationtype) {
		this.organizationtype = organizationtype;
	}

	public String getOrganizationname() {
		return organizationname;
	}

	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
}