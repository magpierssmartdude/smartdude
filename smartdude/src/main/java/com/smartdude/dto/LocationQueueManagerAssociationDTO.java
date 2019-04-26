package com.smartdude.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.smartdude.entity.Queue;
import com.smartdude.entity.Vendor;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LocationQueueManagerAssociationDTO {
	
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
	
	@ApiModelProperty(notes = "Vendor Details", required = true)
	private Vendor vendor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locationQueueManagerAssociation")
	private List<Queue> queues;
}
