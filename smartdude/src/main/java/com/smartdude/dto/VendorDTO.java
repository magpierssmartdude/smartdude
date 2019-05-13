package com.smartdude.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.smartdude.entity.LocationDetail;
import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.QueueManager;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VendorDTO {

	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	private Integer vendorid;

	@ApiModelProperty(notes = "Vendor Code", required = true)
	private String vendorcode;

	@ApiModelProperty(notes = "Vendor Name")
	private String vendorname;
	
	@ApiModelProperty(notes = "Vendor Organizantion Type")
	private String organizationtype;
	
	@ApiModelProperty(notes = "Vendor Authenticated Time", required = true)
	private LocalDateTime authendicatedtime;

	@ApiModelProperty(notes = "Vendor Organizantion Name")
	private String organizationname;
	
	@ApiModelProperty(notes = "Vendor Password")
	private String password;
	
	@ApiModelProperty(notes = "Vendor Hand Phone")
	private String phonenumber;
	
	@ApiModelProperty(notes = "Vendor Created TIme Stamp")
	private LocalDateTime createdTimeStamp;
	
	@ApiModelProperty(notes = "Status Of The Vendor")
	private Boolean status;
	
	@ApiModelProperty(notes = "Vendor Location Details")
	private List<LocationDetail> locationdetails;
	
	@ApiModelProperty(notes = "Vendor Queue Details")
	private List<QueueManager> queuemanagers;
	
	@ApiModelProperty(notes = "Vendor Queue Details")
	private List<LocationQueueManagerAssociation> locationQueueManagerAssociations;
}
