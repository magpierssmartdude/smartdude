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

import lombok.Data;

@Entity
@Table(name="service")
@Data
public class Service implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8740797331322269436L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer serviceid;
	
	private String servicename;
	
	private Integer noofserves;
	
	private Integer units;
	
	private Float price;
	
	private Integer altertquantity;
	
	private LocalDateTime createdtimestamp;
	
	private boolean status;
	
	private LocalDateTime updatedtimestamp;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "queueid", nullable = false)
	private Queue queue;
	

}
