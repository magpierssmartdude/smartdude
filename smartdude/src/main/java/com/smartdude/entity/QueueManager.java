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
@Table(name="queue_manager")
public class QueueManager implements Serializable{

	private static final long serialVersionUID = 8204683531454364262L;

	@Id
	@ApiModelProperty(notes = "Queue Manager Unique ID", required = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "queue_manager_id")
	private Integer queueManagerId;
	
	@ApiModelProperty(notes = "Queue Manager Name")
	@Column(name = "queue_manager_name")
	private String queueManagerName;
	
	@ApiModelProperty(notes = "Queue Manager Hand Phone")
	@Column(name = "queue_manager_phone_number")
	private String qManagerPhoneNumber;
	
	@ApiModelProperty(notes = "Queue Manager Email ID")
	@Column(name = "queue_manager_email_id")
	private String qManagerEmailId;
	
	@ApiModelProperty(notes = "Queue Manager Password")
	@Column(name = "queue_manager_password")
	private String qManagerPassword;

	@ApiModelProperty(notes = "Queue Manager Created TimeStamp")
	@Column(name = "queue_manager_create_timestamp")
	private LocalDateTime createdtimestamp;
	
	@ApiModelProperty(notes = "Queue Manager Last Updated TimeStamp")
	@Column(name = "queue_manager_update_timestamp")
	private LocalDateTime updatedtimestamp;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	@JoinColumn(name = "vendor_id", nullable = false)
	private Vendor vendor;
}
