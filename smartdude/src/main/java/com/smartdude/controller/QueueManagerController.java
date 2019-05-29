package com.smartdude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartdude.dto.DaysDTO;
import com.smartdude.dto.LocationQueueManagerAssociationDTO;
import com.smartdude.dto.QueueDTO;
import com.smartdude.dto.QueueManagerDTO;
import com.smartdude.dto.ServiceDTO;
import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.Queue;
import com.smartdude.entity.QueueManager;
import com.smartdude.entity.Service;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.ParameterNotFound;
import com.smartdude.service.QueuemanagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Queue Manager Controller", tags = "Queue Manager API", consumes = "application/json")
public class QueueManagerController {

	@Autowired
	private QueuemanagerService queuemanagerService;

	@ApiOperation(value = "To Save Queue Manager Details", response = QueueManagerDTO.class, nickname = "Queue Manager SignUp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueManagerDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Queue Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/vendor/qmanager")
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
	@PutMapping("/vendor/qmanager/{qmanagerID}")
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
	@GetMapping("/vendor/{vendorID}/qmanagers")
	public ResponseEntity<List<QueueManagerDTO>> getQManagerDetails(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID)
			throws EntityNotFoundException {
		List<QueueManagerDTO> managerList = queuemanagerService.findQManagerByVendorID(vendorID);
		return new ResponseEntity<>(managerList, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Queue Manager Details For A Given Vendor ID & Queue Manager ID", response = QueueManagerDTO.class, nickname = "Queue Manager Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueManagerDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Queue Manager Details Not Found For The Provided Vendor ID & Queue Manager ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/vendor/{vendorID}/qmanagers/{qmanagerID}")
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
	@PostMapping("/vendor/{vendorID}/associatelocationqmanager")
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
	@GetMapping("/vendor/{vendorID}/associatelocationqmanager")
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
	@PostMapping("/vendor/{vendorID}/associatelocationqmanager/{associateLocationQmanagerID}")
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
	@GetMapping("/qm/{queuemanagerid}/getlocationassociations")
	public ResponseEntity<LocationQueueManagerAssociationDTO> findByQMId(
			@ApiParam(value = "Queue Manager's Unique ID", required = true, allowMultiple = false, name = "queuemanagerid") @PathVariable("queuemanagerid") Integer qmID)
			throws EntityNotFoundException {
		LocationQueueManagerAssociationDTO locationQueueManagerAssociationDTO = queuemanagerService
				.findAssocationBQMID(qmID);
		return new ResponseEntity<>(locationQueueManagerAssociationDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Create Queue", response = Queue.class, nickname = "Queue Creation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error In Saving Queue Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/qm/queue")
	public ResponseEntity<QueueDTO> createQueue(
			@ApiParam(value = "Queue Details", required = true, name = "queue") @RequestBody Queue queue)
			throws EntitySaveException {
		QueueDTO queueDTO = queuemanagerService.save(queue);
		return new ResponseEntity<>(queueDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Updating Queue Details", response = Queue.class, nickname = "Queue Updation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error In Updating Queue Details", response = com.smartdude.entity.exception.Error.class),
			@ApiResponse(code = 400, message = "PNF-> Incorrect Parameter", response = com.smartdude.entity.exception.Error.class),
			@ApiResponse(code = 404, message = "ENF-> Queue Details Not Found ", response = com.smartdude.entity.exception.Error.class) })
	@PutMapping("/qm/queue/{queueid}")
	public ResponseEntity<QueueDTO> updateQueue(
			@ApiParam(value = "Queue Details", required = true, name = "queue") @RequestBody Queue queue,
			@ApiParam(value = "Queue Unique ID", required = true, allowMultiple = false, name = "queueid") @PathVariable("queueid") Integer queueid)
			throws ParameterNotFound, EntitySaveException, EntityNotFoundException {
		QueueDTO queueDTO = queuemanagerService.update(queue, queueid);
		return new ResponseEntity<>(queueDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Queue Details With Queue Manager Location Association ID", response = QueueDTO.class, nickname = "Queue Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Queue Details Not Found ", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/qm/{qmaID}/queue")
	public ResponseEntity<List<QueueDTO>> findQueuesByQManagerAssociationID(
			@ApiParam(value = "Queue Manager Location Association Unique ID", required = true, allowMultiple = false, name = "qmaID") @PathVariable("qmaID") Integer qmID)
			throws EntityNotFoundException {
		List<QueueDTO> dtoList = queuemanagerService.findQByQManagerAssociationID(qmID);
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

	@ApiOperation(value = "Queue Details With Queue Manager ID And Queue ID", response = QueueDTO.class, nickname = "Queue Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = QueueDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Queue Details Not Found", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/qm/{qmaID}/queue/{queueid}")
	public ResponseEntity<QueueDTO> findQueueByQueueIDAndQManagerAssociationID(
			@ApiParam(value = "Queue Manager Location Association Unique ID", required = true, allowMultiple = false, name = "qmaID") @PathVariable("qmaID") Integer qmID,
			@ApiParam(value = "Queue Unique ID", required = true, allowMultiple = false, name = "queueid") @PathVariable("queueid") Integer queueid)
			throws EntityNotFoundException {
		QueueDTO queueDTO = queuemanagerService.findQByQueueidAndQManagerAssociationID(qmID, queueid);
		return new ResponseEntity<>(queueDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Create Service", response = ServiceDTO.class, nickname = "Service Creation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ServiceDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error In Saving Queue Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/qm/service")
	public ResponseEntity<ServiceDTO> addService(
			@ApiParam(value = "service Details", required = true, name = "service") @RequestBody Service service)
			throws EntitySaveException {
		ServiceDTO serviceDTO = queuemanagerService.saveService(service);
		return new ResponseEntity<>(serviceDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Update Service Details", response = ServiceDTO.class, nickname = "Service Updation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ServiceDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error In Updating Service Details", response = com.smartdude.entity.exception.Error.class),
			@ApiResponse(code = 404, message = "ENF-> Service Details Not Found", response = com.smartdude.entity.exception.Error.class) })
	@PutMapping("qm/service/{serviceid}")
	public ResponseEntity<ServiceDTO> updateService(
			@ApiParam(value = "service Details", required = true, name = "service") @RequestBody Service service,
			@ApiParam(value = "Unique Service ID", required = true, allowMultiple = false, name = "serviceid") @PathVariable("serviceid") Integer serviceid)
			throws EntityNotFoundException, EntitySaveException {
		ServiceDTO serviceDTO = queuemanagerService.updateService(service, serviceid);
		return new ResponseEntity<>(serviceDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Service Details", response = ServiceDTO.class, nickname = "Service Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ServiceDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Service Details Not Found", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("qm/{queueid}/service")
	public ResponseEntity<List<ServiceDTO>> getAllServicesByQueueID(
			@ApiParam(value = "Unique Queue ID", required = true, allowMultiple = false, name = "queueid") @PathVariable("queueid") Integer queueid)
			throws EntityNotFoundException {
		List<ServiceDTO> serviceList = queuemanagerService.getServiceByQueueID(queueid);
		return new ResponseEntity<>(serviceList, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Service Details", response = ServiceDTO.class, nickname = "Service Updation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ServiceDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Service Details Not Found", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("qm/{queueid}/service/{serviceid}")
	public ResponseEntity<ServiceDTO> getAllServicesByQueueIDAndServiceID(
			@ApiParam(value = "Unique Queue ID", required = true, allowMultiple = false, name = "queueid") @PathVariable("queueid") Integer queueid,
			@ApiParam(value = "Unique Service ID", required = true, allowMultiple = false, name = "serviceid") @PathVariable("serviceid") Integer serviceID)
			throws EntityNotFoundException {
		ServiceDTO serviceDTO = queuemanagerService.getServiceByQueueIDAndServiceID(queueid, serviceID);
		return new ResponseEntity<>(serviceDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Service Days Details", response = Queue.class, nickname = "Service Updation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ServiceDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Days Details Not Found", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("service/{serviceid}/days")
	public ResponseEntity<List<DaysDTO>> getServiceRunningDays(
			@ApiParam(value = "Unique Service ID", required = true, allowMultiple = false, name = "serviceid") @PathVariable("serviceid") Integer serviceid)
			throws ParameterNotFound, EntityNotFoundException {
		List<DaysDTO> daysList = queuemanagerService.getDays(serviceid);
		return new ResponseEntity<>(daysList, HttpStatus.OK);
	}
}
