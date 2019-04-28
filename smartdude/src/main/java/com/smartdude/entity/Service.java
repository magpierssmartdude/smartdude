package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "service")
@Data
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8740797331322269436L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Unique ID For Each Service")
	private Integer serviceid;

	@ApiModelProperty(notes = "Service Name")
	private String servicename;

	@ApiModelProperty(notes = "Number Of Serves Of The Service")
	private Integer noofserves;

	@ApiModelProperty(notes = "Measurement Unit Of The Service")
	private Integer units;

	@ApiModelProperty(notes = "Days When The Service To Be Created", allowableValues = "MON, TUE, WED, THU, FRI, SAT, SUN")
	private String days;

	@ApiModelProperty(notes = "Price Of Each Service")
	private Float price;

	@ApiModelProperty(notes = "Quantity Of The Service Added Recently")
	private Integer altertquantity;

	@ApiModelProperty(notes = "Service Created Date And Time")
	private LocalDateTime createdtimestamp;

	@ApiModelProperty(notes = "Status Of The Service")
	private boolean status;

	@ApiModelProperty(notes = "Last Updated Date And Time")
	private LocalDateTime updatedtimestamp;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Queue Details Of The Service")
	@JoinColumn(name = "queueid", nullable = false)
	private Queue queue;
}
