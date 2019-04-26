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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vendor")
@AllArgsConstructor
@NoArgsConstructor
public class Vendor implements Serializable {

	private static final long serialVersionUID = -8877257344432213092L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	@Column(name = "vendorid")
	private Integer vendorid;

	@ApiModelProperty(notes = "Vendor Code", required = true)
	@Column(name = "vendorcode")
	private String vendorcode;

	@ApiModelProperty(notes = "Vendor Name")
	@Column(name = "vendorname")
	private String vendorname;
	
	@ApiModelProperty(notes = "Vendor Organizantion Type")
	@Column(name = "organizationtype")
	private String organizationtype;
	
	@ApiModelProperty(notes = "Vendor Authenticated Time", required = true)
	@Column(name = "authendicatedtime")
	private LocalDateTime authendicatedtime;

	@ApiModelProperty(notes = "Vendor Organizantion Name")
	@Column(name = "organizationname")
	private String organizationname;
	
	@ApiModelProperty(notes = "Vendor Password")
	@Column(name = "password")
	private String password;
	
	@ApiModelProperty(notes = "Vendor Hand Phone")
	@Column(name = "phonenumber")
	private String phonenumber;
	
	@ApiModelProperty(notes = "Vendor Created TIme Stamp")
	@Column(name = "createdtimestamp")
	private LocalDateTime createdTimeStamp;
	
	@ApiModelProperty(notes = "Status Of The Vendor")
	@Column(name = "status")
	private Boolean status;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vendor")
	@ApiModelProperty(notes = "Vendor Location Details")
	private List<LocationDetail> locationdetails;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vendor")
	@ApiModelProperty(notes = "Vendor Queue Details")
	private List<QueueManager> queuemanagers;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vendor")
	@ApiModelProperty(notes = "Vendor Queue Details")
	private List<LocationQueueManagerAssociation> locationQueueManagerAssociations;
}
