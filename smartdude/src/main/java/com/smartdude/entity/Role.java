package com.smartdude.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleid")
	@ApiModelProperty(notes = "Unique Role ID", required = true)
	private Integer roleId;
	
	@Column(name="rolecode")
	@ApiModelProperty(notes = "Role Code", required = true)
	private String roleCode;
}
