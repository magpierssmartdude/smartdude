package com.smartdude.entity;

import java.time.LocalDateTime;

import javax.persistence.Id;

public class LocationQueueManagerAssociation {

	@Id
	private String associationCode;
	
	private String activeStatus;
	
	private QueueManager queueManager;
	
	private VendorLocationDetail vendorLocationDetail;
	
	private LocalDateTime createdTimeStamp;
	
}
