package com.smartdude.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VendorDTO {

	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	private Integer vendorId;

	@ApiModelProperty(notes = "Vendor Code", required = true)
	private String vendorCode;

	@ApiModelProperty(notes = "Vendor Name", required = true)
	private String vendorName;

	@ApiModelProperty(notes = "Vendor Organizantion Type", required = true)
	private String organizationType;

	@ApiModelProperty(notes = "Vendor Authenticated Time", required = true)
	private LocalDateTime authendicatedTime;

	@ApiModelProperty(notes = "Vendor Organizantion Name", required = true)
	private String organizationName;

	@ApiModelProperty(notes = "Vendor Password", required = true)
	private String password;

	@ApiModelProperty(notes = "Vendor Hand Phone", required = true)
	private String phoneNumber;

	@ApiModelProperty(notes = "Vendor Created TIme Stamp", required = true)
	private LocalDateTime createdTimeStamp;

}
