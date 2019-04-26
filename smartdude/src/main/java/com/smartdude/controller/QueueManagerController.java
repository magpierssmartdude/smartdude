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

import com.smartdude.dto.LocationQueueManagerAssociationDTO;
import com.smartdude.dto.QueueManagerDTO;
import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.Queue;
import com.smartdude.entity.QueueManager;
import com.smartdude.entity.Service;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.ParameterNotFound;
import com.smartdude.service.QueuemanagerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class QueueManagerController {

	@Autowired
	private QueuemanagerService queuemanagerService;

	@ApiOperation(value = "To Save Queue Manager Details", response = QueueManagerDTO.class, nickname = "Queue Manager SignUp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueManagerDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Queue Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/vendor/qManager")
	public ResponseEntity<QueueManagerDTO> saveQManager(
			@ApiParam(value = "Queue Manager Details", required = true, name = "queueManager") @RequestBody QueueManager queueManager)
			throws EntitySaveException {
		QueueManagerDTO queueManagerDTO = queuemanagerService.save(queueManager);
		return new ResponseEntity<>(queueManagerDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "To Update Queue Manager Details", response = QueueManagerDTO.class, nickname = "Queue Manager Update")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueManagerDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Queue Mager Details", response = com.smartdude.entity.exception.Error.class),
			@ApiResponse(code = 400, message = "PNF-> Invalid Parameter Given For Updating Queue Manager Details", response = com.smartdude.entity.exception.Error.class) })
	@PutMapping("/vendor/qManager/{qmanagerID}")
	public ResponseEntity<QueueManagerDTO> updateQManager(
			@ApiParam(value = "Queue Manager Details", required = true, name = "queueManager") @RequestBody QueueManager queueManager,
			@ApiParam(value = "Queue Manager's Unique Code", required = true, allowMultiple = false, name = "qmanagerID") @PathVariable("qmanagerID") Integer qManagerID)
			throws ParameterNotFound, EntitySaveException {
		QueueManagerDTO queueManagerDTO = queuemanagerService.update(queueManager, qManagerID);
		return new ResponseEntity<>(queueManagerDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Queue Manager Details For A Given Vendor ID", response = QueueManagerDTO.class, nickname = "Queue Manager Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueManagerDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Queue Manager Details Not Found For The Provided Vendor ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/vendor/{vendorID}/qManagers")
	public ResponseEntity<List<QueueManagerDTO>> getQManagerDetails(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID)
			throws EntityNotFoundException {
		List<QueueManagerDTO> managerList = queuemanagerService.findQManagerByVendorID(vendorID);
		return new ResponseEntity<>(managerList, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Queue Manager Details For A Given Vendor ID & Queue Manager ID", response = QueueManagerDTO.class, nickname = "Queue Manager Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueManagerDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Queue Manager Details Not Found For The Provided Vendor ID & Queue Manager ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/vendor/{vendorID}/qManagers/{qmanagerID}")
	public ResponseEntity<QueueManagerDTO> getQManagerDetail(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID,
			@ApiParam(value = "Queue Manager's Unique Code", required = true, allowMultiple = false, name = "qmanagerID") @PathVariable("qmanagerID") Integer qmanagerID)
			throws EntityNotFoundException {
		QueueManagerDTO queueManagerDTO = queuemanagerService.findQManagerByVendorIDAndQmID(vendorID, qmanagerID);
		return new ResponseEntity<>(queueManagerDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "To Save Location Queue Manager Association", response = LocationQueueManagerAssociationDTO.class, nickname = "Location Queue Manager Signup")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = LocationQueueManagerAssociationDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Location Queue Manager Association Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/vendor/{vendorID}/associateLocationQmanager")
	public ResponseEntity<LocationQueueManagerAssociationDTO> saveQManagerLocationAssociation(
			@ApiParam(value = "Location Queue Manager Association Details", required = true, name = "queueManager") @RequestBody LocationQueueManagerAssociation queueManager,
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID)
			throws ParameterNotFound, EntitySaveException {
		LocationQueueManagerAssociationDTO locationQueueManagerAssociationDTO = queuemanagerService.save(queueManager,
				vendorID);
		return new ResponseEntity<>(locationQueueManagerAssociationDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Find Location Queue Manager Association Details With Vendor ID", response = LocationQueueManagerAssociationDTO.class, nickname = "Location Queue Manager Details")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = LocationQueueManagerAssociationDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Location Queue Manager Association Details Not Found For The Provided Vendor ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/vendor/{vendorID}/associateLocationQmanager")
	public ResponseEntity<LocationQueueManagerAssociationDTO> getQManagerLocationAssociation(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID)
			throws EntityNotFoundException {
		LocationQueueManagerAssociationDTO locationQueueManagerAssociationDTO = queuemanagerService
				.findByVendorID(vendorID);
		return new ResponseEntity<>(locationQueueManagerAssociationDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Location Queue Manager Association Details Update", response = LocationQueueManagerAssociationDTO.class, nickname = "Update Location Queue Manager Details")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = LocationQueueManagerAssociationDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Updating Location Queue Mager Association Details", response = com.smartdude.entity.exception.Error.class),
			@ApiResponse(code = 404, message = "ENF-> Location Queue Manager Association Details Not Found For The Provided Vendor ID & Location Queue Manager ID", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/vendor/{vendorID}/associateLocationQmanager/{associateLocationQmanagerID}")
	public ResponseEntity<LocationQueueManagerAssociationDTO> updateQManagerLocationAssociation(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID,
			@ApiParam(value = "Location Queue Manager Association Unique Code", required = true, allowMultiple = false, name = "associateLocationQmanagerID") @PathVariable("associateLocationQmanagerID") Integer associateLocationQmanagerID,
			@ApiParam(value = "Status To Be Updated", required = true, allowMultiple = false, name = "status") @RequestParam(required = true) Boolean status)
			throws EntityNotFoundException, EntitySaveException {
		LocationQueueManagerAssociationDTO locationQueueManagerAssociationDTO = queuemanagerService
				.updateAssociation(vendorID, associateLocationQmanagerID, status);
		return new ResponseEntity<>(locationQueueManagerAssociationDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Location Queue Manager Association Details For Given Queue Manager ID", response = LocationQueueManagerAssociationDTO.class, nickname = "Location Queue Manager Details")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = LocationQueueManagerAssociationDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Location Queue Manager Association Details Not Found For The Provided Queue Manager ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/qm/{queuemanagerid}/getLocationAssociations")
	public ResponseEntity<LocationQueueManagerAssociationDTO> findByQMId(
			@ApiParam(value = "Queue Manager's Unique ID", required = true, allowMultiple = false, name = "queuemanagerid") @PathVariable("queuemanagerid") Integer qmID)
			throws EntityNotFoundException {
		LocationQueueManagerAssociationDTO locationQueueManagerAssociationDTO = queuemanagerService
				.findAssocationBQMID(qmID);
		return new ResponseEntity<>(locationQueueManagerAssociationDTO, HttpStatus.OK);
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
	public Service updateService(@RequestBody Service service, @PathVariable("serviceid") Integer serviceid) {
		return queuemanagerService.updateService(service, serviceid);
	}

	@GetMapping("qm/{queueid}/service")
	public List<Service> getAllServicesByQueueID(@PathVariable("queueid") Integer queueid) {
		return queuemanagerService.getServiceByQueueID(queueid);
	}

	@GetMapping("qm/{queueid}/service/{serviceid}")
	public Service getAllServicesByQueueIDAndServiceID(@PathVariable("queueid") Integer queueid,
			@PathVariable("serviceid") Integer serviceID) {
		return queuemanagerService.getServiceByQueueIDAndServiceID(queueid, serviceID);
	}

}
