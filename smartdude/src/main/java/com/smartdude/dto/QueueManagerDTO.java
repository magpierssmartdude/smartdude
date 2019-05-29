package com.smartdude.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class QueueManagerDTO {

	private Integer queuemanagerid;
 
	private String queuemanagername;

	private String qmanagerphonenumber;
	
	
	private String qmanageremailId;
	

	private String qmanagerpassword;

	private Integer vendorid;
	
	private LocalDateTime createdtimestamp;

	private LocalDateTime updatedtimestamp;


	private Boolean activestatus;
}
