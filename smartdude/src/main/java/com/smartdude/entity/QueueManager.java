package com.smartdude.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="queuemanager")
public class QueueManager {

	@Id
	private String queueManagerID;
	
	private String queueMaangerName;
	
	private String tempPassword;
	
	private String mobileNumber;
	
	
}
