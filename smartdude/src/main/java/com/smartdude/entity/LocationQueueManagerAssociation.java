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
	private Integer locqmanagerassociationid;
	
	private Boolean activestatus;
	
	private Integer locationid;
	
	private Integer qmanagerid;
	
	private LocalDateTime createdtimestamp;
	
	private LocalDateTime updatedtimestamp;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	@JoinColumn(name = "vendorid", nullable = false)
	private Vendor vendor;
	

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locationQueueManagerAssociation")
	private List<Queue> queues;
}
