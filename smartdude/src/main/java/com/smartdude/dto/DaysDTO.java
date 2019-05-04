package com.smartdude.dto;

import com.smartdude.entity.Service;

import io.swagger.annotations.ApiModelProperty;

public class DaysDTO {
	
	@ApiModelProperty(notes = "Name Of Day", allowableValues = "SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY")
	private String dayname;
	
	@ApiModelProperty(notes = "Code For Each Day", allowableValues = "SUN, MON, TUE, WED, THU, FRI, SAT")
	private String daycode;
	
	@ApiModelProperty(notes = "No Of Hours The Service Has To Run For The Day")
	private Integer noOfHours;
	
	@ApiModelProperty(notes = "The Time, Service Has To Start")
	private Integer startTime;
	
	@ApiModelProperty(notes = "The Time, Service Has To End")
	private Integer endTime;

	@ApiModelProperty(notes = "Service Unique ID", required = true)
	private Service service;
}
