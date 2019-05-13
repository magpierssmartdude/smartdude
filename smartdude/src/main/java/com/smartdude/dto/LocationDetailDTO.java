package com.smartdude.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LocationDetailDTO {
	@ApiModelProperty(notes = "Vendor Unique Location ID", required = true)
	private int locationid;
	
	@ApiModelProperty(notes = "Vendor Location State Name", required = true)
	private String state;
	
	@ApiModelProperty(notes = "Vendor Location City Name", required = true)
	private String city;
	
	@ApiModelProperty(notes = "Vendor Location Area Name", required = true)
	private String area;
	
	@ApiModelProperty(notes = "Vendor Location Area Landmark Name", required = true)
	private String landmark;
	
	@ApiModelProperty(notes = "Vendor Building Name", required = true)
	private String building;
	
	@ApiModelProperty(notes = "Vendor Building Floor Detail", required = true)
	private String floor;
	
	@ApiModelProperty(notes = "Vendor Building Block Detail", required = true)
	private String block;

	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	private Integer vendorid;
}
