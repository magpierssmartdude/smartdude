package com.smartdude.entity;

import java.time.LocalDateTime;

import javax.persistence.Id;

public class QueueManager {

	@Id
	private String queueManagerID;
	
	private String queueMaangerName;
	
	private String tempPassword;
	
	private String mobileNumber;
	
	private LocalDateTime createdTimeStamp;
	
	private Boolean activeStatus;
	
	
}
