package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Table(name="queue")
@Entity
@Data
public class Queue implements Serializable{

	private static final long serialVersionUID = 8275470637268467963L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique Queue ID", required = true)
	@Column(name = "qmanagerid")
	private Integer queueid;
	
	@ApiModelProperty(notes = "Queue Name", required = true)
	@Column(name = "queuename")
	private String queuename;
	
	@ApiModelProperty(notes = "Location Queue Manager Association Details", required = true)
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loctionqmanagerassociationid", nullable = false)
	private LocationQueueManagerAssociation locationQueueManagerAssociation;
	
	@Column(name = "createddatetime")
	@ApiModelProperty(notes = "Queue Created Date And Time", required = true)
	private LocalDateTime createddatetime;
	
	@Column(name = "createdmanagerid")
	@ApiModelProperty(notes = "Queue Creator ID", required = true)
	private Integer createdmanagerid;
	
	@Column(name = "lastupdatetime")
	@ApiModelProperty(notes = "Queue Updated Date And Time", required = true)
	private LocalDateTime lastupdatetime;
	
	@Column(name = "activestatus")
	@ApiModelProperty(notes = "Queue Status", required = true)
	private boolean activestatus;
	
	@Column(name = "queueendtime")
	@ApiModelProperty(notes = "Queue End Time", required = true)
	private LocalTime queueendtime;
	
	@Column(name = "queuestarttime")
	@ApiModelProperty(notes = "Queue Start Time", required = true)
	private LocalTime queuestarttime;
	
	@ApiModelProperty(notes = "Queue Service Details", required = true)
	@Column(name = "serviceid")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "queue")
	private List<Service> service;
}
