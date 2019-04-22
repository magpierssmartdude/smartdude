package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.Data;

@Table(name="queue")
@Entity
@Data
public class Queue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8275470637268467963L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer queueid;
	
	private String queuename;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loctionqmanagerassociationid", nullable = false)
	private LocationQueueManagerAssociation locationQueueManagerAssociation;
	
	private LocalDateTime createddatetime;
	
	private Integer createdmanagerid;
	
	private LocalDateTime lastupdatetime;
	
	private boolean activestatus;
	
	private LocalTime queueendtime;
	
	private LocalTime queuestarttime;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "queue")
	private List<Service> service;
	
}
