package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
@Table(name="queuemanager")
public class QueueManager implements Serializable{

	private static final long serialVersionUID = 8204683531454364262L;

	@Id
	@ApiModelProperty(notes = "Queue Manager Unique ID", required = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "qmanagerid")
	private Integer queuemanagerid;
	
	@ApiModelProperty(notes = "Queue Manager Name")
	@Column(name = "qmanagername")
	private String queuemanagername;
	
	@ApiModelProperty(notes = "Queue Manager Hand Phone")
	@Column(name = "qmanagerphonenumber")
	private String qmanagerphonenumber;
	
	@ApiModelProperty(notes = "Queue Manager Email ID")
	@Column(name = "qmanageremailid")
	private String qmanageremailId;
	
	@ApiModelProperty(notes = "Queue Manager Password")
	@Column(name = "qmanagerpassword")
	private String qmanagerpassword;

	@ApiModelProperty(notes = "Queue Manager Created TimeStamp")
	@Column(name = "createdtimestamp")
	private LocalDateTime createdtimestamp;
	
	@ApiModelProperty(notes = "Queue Manager Last Updated TimeStamp")
	@Column(name = "updatedtimestamp")
	private LocalDateTime updatedtimestamp;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	@JoinColumn(name = "vendorid", nullable = false)
	private Vendor vendor;
	
	@Column(name="activestatus")
	private Boolean activestatus;
	
}
