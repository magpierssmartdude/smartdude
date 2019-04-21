package com.smartdude.entity;

import java.time.LocalDateTime;

import javax.persistence.Id;

import lombok.Data;

@Data
public class LocationQueueManagerAssociation {

	@Id
	private String associationCode;
	
	private String activeStatus;
	
	private QueueManager queueManager;
	
	private LocalDateTime createdTimeStamp;
	
}
