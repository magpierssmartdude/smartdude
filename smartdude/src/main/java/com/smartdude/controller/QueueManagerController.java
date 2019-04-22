package com.smartdude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@PostMapping("/vendor/saveQManager")
	public QueueManager saveQManager(@RequestBody QueueManager queueManager) {
		return queuemanagerService.save(queueManager);
	}
	
	@PostMapping("/vendor/associateLocationQmanager")
	public LocationQueueManagerAssociation saveQManagerLocationAssociation(@RequestBody LocationQueueManagerAssociation queueManager) {
		return queuemanagerService.save(queueManager);
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
