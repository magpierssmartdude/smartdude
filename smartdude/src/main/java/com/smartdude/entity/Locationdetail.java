package com.smartdude.entity;

import java.io.Serializable;

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

@Entity
@Table(name="locationdetail")
public class Locationdetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3401167705803097444L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int locationid;
	private String state;
	private String city;
	private String area;
	private String landmark;
	private String building;
	private String floor;
	private String block;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorid", nullable = false)
	private Vendor vendor;
	

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getState(){
		return state;
	}

	public void setState(String state){
		this.state=state;
	}

	public String getCity(){
		return city;
	}

	public void setCity(String city){
		this.city=city;
	}

	public String getArea(){
		return area;
	}

	public void setArea(String area){
		this.area=area;
	}

	public String getLandmark(){
		return landmark;
	}

	public void setLandmark(String landmark){
		this.landmark=landmark;
	}

	public String getBuilding(){
		return building;
	}

	public void setBuilding(String building){
		this.building=building;
	}

	public String getFloor(){
		return floor;
	}

	public void setFloor(String floor){
		this.floor=floor;
	}

	public String getBlock(){
		return block;
	}

	public void setBlock(String block){
		this.block=block;
	}

 
}