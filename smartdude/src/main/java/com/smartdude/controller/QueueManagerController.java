package com.smartdude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.Queue;
import com.smartdude.entity.QueueManager;
import com.smartdude.entity.Service;
import com.smartdude.service.QueuemanagerService;

@RestController
public class QueueManagerController {

	
 
	@Autowired
	private QueuemanagerService queuemanagerService;
	
	
	@PostMapping("/vendor/qManager")
	public QueueManager saveQManager(@RequestBody QueueManager queueManager) {
		return queuemanagerService.save(queueManager);
	}
	
	@PutMapping("/vendor/qManager/{qmanagerID}")
	public QueueManager updateQManager(@RequestBody QueueManager queueManager,
			@PathVariable("qmanagerID") Integer qManagerID) {
		return queuemanagerService.update(queueManager,qManagerID);
	}

	@GetMapping("/vendor/{vendorID}/qManagers")
	public List<QueueManager> getQManagerDetails(@PathVariable("vendorID") Integer vendorID) {
		return queuemanagerService.findQManagerByVendorID(vendorID);
	}
	
	@GetMapping("/vendor/{vendorID}/qManagers/{qmanagerID}")
	public QueueManager getQManagerDetail(@PathVariable("vendorID") Integer vendorID,@PathVariable("qmanagerID")Integer qmanagerID) {
		return queuemanagerService.findQManagerByVendorIDAndQmID(vendorID,qmanagerID);
	}
	
	
	@PostMapping("/vendor/{vendorID}/associateLocationQmanager")
	public LocationQueueManagerAssociation saveQManagerLocationAssociation(
			@RequestBody LocationQueueManagerAssociation queueManager,@PathVariable("vendorID") Integer vendorID) {
		return queuemanagerService.save(queueManager,vendorID);
	}
	
	@PostMapping("/qm/createQueue")
	public Queue createQueue(@RequestBody Queue queue) {
		return queuemanagerService.save(queue);
	}
	
	@PostMapping("/qm/addService")
	public Service addService(@RequestBody Service service) {
		return queuemanagerService.saveService(service);
	}
}
