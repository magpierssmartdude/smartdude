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
@Data
@Table(name = "locationdetail")
public class LocationDetail implements Serializable {

	private static final long serialVersionUID = 3401167705803097444L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Vendor Unique Location ID", required = true)
	@Column(name = "locationid")
	private int locationid;
	
	@ApiModelProperty(notes = "Vendor Location State Name", required = true)
	@Column(name = "state")
	private String state;
	
	@ApiModelProperty(notes = "Vendor Location City Name", required = true)
	@Column(name = "city")
	private String city;
	
	@ApiModelProperty(notes = "Vendor Location Area Name", required = true)
	@Column(name = "area")
	private String area;
	
	@ApiModelProperty(notes = "Vendor Location Area Landmark Name", required = true)
	@Column(name = "landmark")
	private String landmark;
	
	@ApiModelProperty(notes = "Vendor Building Name", required = true)
	@Column(name = "building")
	private String building;
	
	@ApiModelProperty(notes = "Vendor Building Floor Detail", required = true)
	@Column(name = "floor")
	private String floor;
	
	@ApiModelProperty(notes = "Vendor Building Block Detail", required = true)
	@Column(name = "block")
	private String block;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	@JoinColumn(name = "vendorid", nullable = false)
	private Vendor vendor;
}