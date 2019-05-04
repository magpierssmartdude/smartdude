package com.smartdude.entity;

import java.io.Serializable;

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
@Table(name = "days")
@Data
public class Days implements Serializable  {
	
	private static final long serialVersionUID = -8740797331322269436L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dayid")
	@ApiModelProperty(notes = "Unique ID For Day")
	private Integer dayid;
	
	@Column(name = "dayname")
	@ApiModelProperty(notes = "Name Of Day", allowableValues = "SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY")
	private String dayname;
	
	@Column(name = "daycode")
	@ApiModelProperty(notes = "Code For Each Day", allowableValues = "SUN, MON, TUE, WED, THU, FRI, SAT")
	private String daycode;
	
	@Column(name = "noOfHours")
	@ApiModelProperty(notes = "No Of Hours The Service Has To Run For The Day")
	private Integer noOfHours;
	
	@Column(name = "startTime")
	@ApiModelProperty(notes = "The Time, Service Has To Start")
	private Integer startTime;
	
	@Column(name = "endTime")
	@ApiModelProperty(notes = "The Time, Service Has To Start")
	private Integer endTime;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Service Unique ID", required = true)
	@JoinColumn(name = "serviceid", nullable = false)
	private Service service;
}