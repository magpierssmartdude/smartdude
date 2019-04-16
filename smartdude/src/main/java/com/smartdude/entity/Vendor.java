package com.smartdude.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="vendor")
@Data
public class Vendor {

	@Id
	private String vendorCode;
	
	private String vendorName;
	
	private String emailId;
	
	private String phoneNumber;
	
	private String organizationType;
	
	private String organizationName;
	
	private LocalDateTime createdTimeStamp;
	
	private String password;
	
	private String activated;
	
	private List<VendorLocationDetail> vendorLocationDetails;
	
	public List<VendorLocationDetail> getVendorLocationDetails() {
		return vendorLocationDetails;
	}

	public void setVendorLocationDetails(List<VendorLocationDetail> vendorLocationDetails) {
		this.vendorLocationDetails = vendorLocationDetails;
	}

	public String getActivated() {
		return activated;
	}

	public void setActivated(String activated) {
		this.activated = activated;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public LocalDateTime getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getAuthendicatedTime() {
		return authendicatedTime;
	}

	public void setAuthendicatedTime(LocalDateTime authendicatedTime) {
		this.authendicatedTime = authendicatedTime;
	}

	private LocalDateTime authendicatedTime;
	
	
	
}
