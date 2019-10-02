package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="payment")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="paymentid")
	private Integer paymentId;
	
	@Column(name="paymentrefid")
	private String paymentRefId;
	
	@Column(name="paymentdate")
	private LocalDateTime paymentDate;
	
	@Column(name="paymentstatus")
	private String paymentStatus;

}
