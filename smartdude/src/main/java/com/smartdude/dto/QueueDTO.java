package com.smartdude.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.Service;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueueDTO {

	@ApiModelProperty(notes = "Unique Queue ID", required = true)
    private Integer queueid;
	
	@ApiModelProperty(notes = "Queue Name", required = true)
	private String queuename;
	
	@ApiModelProperty(notes = "Location Queue Manager Association Details", required = true)
	private LocationQueueManagerAssociation locationQueueManagerAssociation;
	
	@ApiModelProperty(notes = "Queue Created Date And Time", required = true)
	private LocalDateTime createddatetime;
	
	@ApiModelProperty(notes = "Days When The Queue To Be Created", allowableValues = "MON, TUE, WED, THU, FRI, SAT, SUN")
	private String days;
	
	@ApiModelProperty(notes = "Queue Creator ID", required = true)
	private Integer createdmanagerid;
	
	@ApiModelProperty(notes = "Queue Updated Date And Time", required = true)
	private LocalDateTime lastupdatetime;
	
	@ApiModelProperty(notes = "Queue Status", required = true)
	private boolean activestatus;
	
	@ApiModelProperty(notes = "Queue End Time", required = true)
	private LocalTime queueendtime;
	
	@ApiModelProperty(notes = "Queue Start Time", required = true)
	private LocalTime queuestarttime;
	
	@ApiModelProperty(notes = "Queue Service Details", required = true)
	private List<Service> service;
}
