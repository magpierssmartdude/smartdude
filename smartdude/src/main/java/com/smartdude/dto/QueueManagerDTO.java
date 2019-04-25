package com.smartdude.dto;

import java.time.LocalDateTime;

import com.smartdude.entity.Vendor;

import io.swagger.annotations.ApiModelProperty;

public class QueueManagerDTO {
	@ApiModelProperty(notes = "Queue Manager Unique ID", required = true)
	private Integer queuemanagerid;
	
	@ApiModelProperty(notes = "Queue Manager Name")
	private String queuemanagername;
	
	@ApiModelProperty(notes = "Queue Manager Hand Phone")
	private String qmanagerphonenumber;
	
	@ApiModelProperty(notes = "Queue Manager Email ID")
	private String qmanageremailId;
	
	@ApiModelProperty(notes = "Queue Manager Password")
	private String qmanagerpassword;

	@ApiModelProperty(notes = "Queue Manager Created TimeStamp")
	private LocalDateTime createdtimestamp;
	
	@ApiModelProperty(notes = "Queue Manager Last Updated TimeStamp")
	private LocalDateTime updatedtimestamp;
	
	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	private Vendor vendor;
	
	@ApiModelProperty(notes = "Vendor Active STatus", required = true)
	private Boolean activestatus;
	
}
