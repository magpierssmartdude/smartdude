package com.smartdude.dto;

import java.time.LocalDateTime;
import com.smartdude.entity.Queue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ServiceDTO {
	
	@ApiModelProperty(notes = "Unique ID For Each Service")
	private Integer serviceid;
	
	@ApiModelProperty(notes = "Service Name")
	private String servicename;
	
	@ApiModelProperty(notes = "Number Of Serves Of The Service")
	private Integer noofserves;
	
	@ApiModelProperty(notes = "Measurement Unit Of The Service")
	private Integer units;
	
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
	
	@ApiModelProperty(notes = "Queue Details Of The Service")
	private Queue queue;
}
