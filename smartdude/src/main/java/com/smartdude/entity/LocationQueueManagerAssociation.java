package com.smartdude.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="locationqmanagerassociation")
@Data
public class LocationQueueManagerAssociation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String locqmanagerid;
	
	private String activestatus;
	
	private Integer locationid;
	
	private Integer qmanagerid;
	
	private LocalDateTime createdtimestamp;
	
	private LocalDateTime updatedtimestamp;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locationQueueManagerAssociation")
	private List<Queue> queues;
}
