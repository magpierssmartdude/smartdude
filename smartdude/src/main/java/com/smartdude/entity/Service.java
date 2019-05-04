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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "service")
@Data
public class Service implements Serializable {

	private static final long serialVersionUID = -8740797331322269436L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique ID For Each Service")
	@Column(name = "serviceid")
	private Integer serviceid;

	@Column(name = "servicename")
	@ApiModelProperty(notes = "Service Name")
	private String servicename;

	@Column(name = "noofserves")
	@ApiModelProperty(notes = "Number Of Serves Of The Service")
	private Integer noofserves;

	@Column(name = "units")
	@ApiModelProperty(notes = "Measurement Unit Of The Service")
	private Integer units;

	@Column(name = "price")
	@ApiModelProperty(notes = "Price Of Each Service")
	private Float price;

	@Column(name = "altertquantity")
	@ApiModelProperty(notes = "Quantity Of The Service Added Recently")
	private Integer altertquantity;

	@Column(name = "createdtimestamp")
	@ApiModelProperty(notes = "Service Created Date And Time")
	private LocalDateTime createdtimestamp;

	@Column(name = "status")
	@ApiModelProperty(notes = "Status Of The Service")
	private boolean status;

	@Column(name = "updatedtimestamp")
	@ApiModelProperty(notes = "Last Updated Date And Time")
	private LocalDateTime updatedtimestamp;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "service")
	@ApiModelProperty(notes = "Days On Which Days Service has to run")
	private List<Days> dayList;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Queue Details Of The Service")
	@JoinColumn(name = "queueid", nullable = false)
	private Queue queue;
}
