package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="vendor")
public class Vendor implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = -8877257344432213092L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer vendorid;

public Integer getVendorid() {
	return vendorid;
}

public void setVendorid(Integer vendorid) {
	this.vendorid = vendorid;
}

public String getVendorcode() {
	return vendorcode;
}

public void setVendorcode(String vendorcode) {
	this.vendorcode = vendorcode;
}

public String getVendorname() {
	return vendorname;
}

public void setVendorname(String vendorname) {
	this.vendorname = vendorname;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Column(name="vendorcode")
private String vendorcode;

@Column(name="vendorname")
private String vendorname;


}
