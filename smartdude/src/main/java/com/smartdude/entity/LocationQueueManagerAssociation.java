package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="locationqmanagerassociation")
@Data
public class LocationQueueManagerAssociation implements Serializable {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Locator Queue Manager Unique ID")
	@Column(name = "locqmanagerassociationid")
	private Integer locqmanagerassociationid;
	
	@Column(name = "activestatus")
	@ApiModelProperty(notes = "Status Of The Association")
	private Boolean activestatus;
	
	@Column(name = "locationid")
	@ApiModelProperty(notes = "Unique Location ID")
	private Integer locationid;
	
	@Column(name = "qmanagerid")
	@ApiModelProperty(notes = "Unique Queue Manager ID")
	private Integer qmanagerid;
	
	@Column(name = "createdtimestamp")
	@ApiModelProperty(notes = "Location Queue Manager Association Created Time And Date")
	private LocalDateTime createdtimestamp;
	
	@Column(name = "updatedtimestamp")
	@ApiModelProperty(notes = "Location Queue Manager Association Details Updated Time And Date")
	private LocalDateTime updatedtimestamp;
	
	
	@Column(name = "queueid")
	@ApiModelProperty(notes = "Queue Details")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locationQueueManagerAssociation")
	private List<Queue> queues;
}
