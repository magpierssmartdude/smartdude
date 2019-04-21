package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="queuemanager")
public class QueueManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8204683531454364262L;

	public Integer getQmanagerid() {
		return qmanagerid;
	}

	public void setQmanagerid(Integer qmanagerid) {
		this.qmanagerid = qmanagerid;
	}

	public LocalDateTime getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(LocalDateTime createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	public LocalDateTime getUpdatedtimestamp() {
		return updatedtimestamp;
	}

	public void setUpdatedtimestamp(LocalDateTime updatedtimestamp) {
		this.updatedtimestamp = updatedtimestamp;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer qmanagerid;
	private String qmanagername;
	private String qmanagerphonenumber;
	private String qmanageremailid;
	private String qmanagerpassword;

	private LocalDateTime createdtimestamp;
	private LocalDateTime updatedtimestamp;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorid", nullable = false)
	private Vendor vendor;
	

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getQmanagername() {
		return qmanagername;
	}

	public void setQmanagername(String qmanagername) {
		this.qmanagername = qmanagername;
	}

	public String getQmanagerphonenumber() {
		return qmanagerphonenumber;
	}

	public void setQmanagerphonenumber(String qmanagerphonenumber) {
		this.qmanagerphonenumber = qmanagerphonenumber;
	}

	public String getQmanageremailid() {
		return qmanageremailid;
	}

	public void setQmanageremailid(String qmanageremailid) {
		this.qmanageremailid = qmanageremailid;
	}

	public String getQmanagerpassword() {
		return qmanagerpassword;
	}

	public void setQmanagerpassword(String qmanagerpassword) {
		this.qmanagerpassword = qmanagerpassword;
	}

 
}
