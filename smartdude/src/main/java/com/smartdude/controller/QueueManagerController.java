package com.smartdude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartdude.dto.QueueManagerDTO;
import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.Queue;
import com.smartdude.entity.QueueManager;
import com.smartdude.entity.Service;
import com.smartdude.entity.Vendor;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.service.QueuemanagerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class QueueManagerController {

	@Autowired
	private QueuemanagerService queuemanagerService;

	@ApiOperation(value = "To Save Vendor Details", response = Vendor.class, nickname = "Vendor SignUp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Vendor.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Queue Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/vendor/qManager")
	public ResponseEntity<QueueManagerDTO> saveQManager(
			@ApiParam(value = "Queue Details", required = true, name = "queueManager") @RequestBody QueueManager queueManager)
			throws EntitySaveException {
		QueueManagerDTO queueManagerDTO = queuemanagerService.save(queueManager);
		return new ResponseEntity<>(queueManagerDTO, HttpStatus.OK);
	}

	@PutMapping("/vendor/qManager/{qmanagerID}")
	public QueueManager updateQManager(@RequestBody QueueManager queueManager,
			@PathVariable("qmanagerID") Integer qManagerID) {
		return queuemanagerService.update(queueManager, qManagerID);
	}

	@GetMapping("/vendor/{vendorID}/qManagers")
	public List<QueueManager> getQManagerDetails(@PathVariable("vendorID") Integer vendorID) {
		return queuemanagerService.findQManagerByVendorID(vendorID);
	}

	@GetMapping("/vendor/{vendorID}/qManagers/{qmanagerID}")
	public QueueManager getQManagerDetail(@PathVariable("vendorID") Integer vendorID,
			@PathVariable("qmanagerID") Integer qmanagerID) {
		return queuemanagerService.findQManagerByVendorIDAndQmID(vendorID, qmanagerID);
	}

	@PostMapping("/vendor/{vendorID}/associateLocationQmanager")
	public LocationQueueManagerAssociation saveQManagerLocationAssociation(
			@RequestBody LocationQueueManagerAssociation queueManager, @PathVariable("vendorID") Integer vendorID) {
		return queuemanagerService.save(queueManager, vendorID);
	}

	@GetMapping("/vendor/{vendorID}/associateLocationQmanager")
	public LocationQueueManagerAssociation getQManagerLocationAssociation(@PathVariable("vendorID") Integer vendorID) {
		return queuemanagerService.findByVendorID(vendorID);
	}

	@PostMapping("/vendor/{vendorID}/associateLocationQmanager/{associateLocationQmanagerID}")
	public LocationQueueManagerAssociation updateQManagerLocationAssociation(@PathVariable("vendorID") Integer vendorID,
			@PathVariable("associateLocationQmanagerID") Integer associateLocationQmanagerID,
			@RequestParam(required = true) Boolean status) {
		return queuemanagerService.updateAssociation(vendorID, associateLocationQmanagerID, status);
	}

	@GetMapping("/qm/{queuemanagerid}/getLocationAssociations")
	public LocationQueueManagerAssociation findByQMId(@PathVariable("queuemanagerid") Integer qmID) {
		return queuemanagerService.findAssocationBQMID(qmID);
	}

	@PostMapping("/qm/queue")
	public Queue createQueue(@RequestBody Queue queue) {
		return queuemanagerService.save(queue);
	}

	@PutMapping("/qm/queue/{queueid}")
	public Queue updateQueue(@RequestBody Queue queue, @PathVariable("queueid") Integer queueid) {
		return queuemanagerService.update(queue, queueid);
	}

	@GetMapping("/qm/{qmaID}/queue")
	public List<Queue> findQueuesByQManagerAssociationID(@PathVariable("qmaID") Integer qmID) {
		return queuemanagerService.findQByQManagerAssociationID(qmID);
	}

	@GetMapping("/qm/{qmaID}/queue/{queueid}")
	public Queue findQueueByQueueIDAndQManagerAssociationID(@PathVariable("qmaID") Integer qmID,
			@PathVariable("queueid") Integer queueid) {
		return queuemanagerService.findQByQueueidAndQManagerAssociationID(qmID, queueid);
	}

	@PostMapping("/qm/service")
	public Service addService(@RequestBody Service service) {
		return queuemanagerService.saveService(service);
	}
	@PutMapping("qm/service/{serviceid}")
	public Service updateService(@RequestBody Service service,@PathVariable("serviceid") Integer serviceid) {
		return queuemanagerService.updateService(service,serviceid);
	}
	
	
	@GetMapping("qm/{queueid}/service")
	public List<Service> getAllServicesByQueueID(@PathVariable("queueid") Integer queueid) {
		return queuemanagerService.getServiceByQueueID(queueid);
	}
	
	
	
	@GetMapping("qm/{queueid}/service/{serviceid}")
	public Service getAllServicesByQueueIDAndServiceID(@PathVariable("queueid") Integer queueid ,@PathVariable("serviceid")Integer serviceID) {
		return queuemanagerService.getServiceByQueueIDAndServiceID(queueid,serviceID);
	}
	
	
}
