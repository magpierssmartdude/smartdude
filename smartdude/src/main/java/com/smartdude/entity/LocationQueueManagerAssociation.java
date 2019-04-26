package com.smartdude.entity;

import java.time.LocalDateTime;
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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="locationqmanagerassociation")
@Data
public class LocationQueueManagerAssociation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Locator Queue Manager Unique ID")
	private Integer locqmanagerassociationid;
	
	@ApiModelProperty(notes = "Status Of The Association")
	private Boolean activestatus;
	
	@ApiModelProperty(notes = "Unique Location ID")
	private Integer locationid;
	
	@ApiModelProperty(notes = "Unique Queue Manager ID")
	private Integer qmanagerid;
	
	@ApiModelProperty(notes = "Location Queue Manager Association Created Time And Date")
	private LocalDateTime createdtimestamp;
	
	@ApiModelProperty(notes = "Location Queue Manager Association Details Updated Time And Date")
	private LocalDateTime updatedtimestamp;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Vendor Details", required = true)
	@JoinColumn(name = "vendorid", nullable = false)
	private Vendor vendor;
	
	@ApiModelProperty(notes = "Queue Details")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locationQueueManagerAssociation")
	private List<Queue> queues;
}
