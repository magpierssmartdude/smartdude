package com.smartdude.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.Queue;
import com.smartdude.entity.QueueManager;
import com.smartdude.repository.LocationQueueManagerAssociationRepository;
import com.smartdude.repository.QueueManagerRepository;
import com.smartdude.repository.QueueRepository;
import com.smartdude.repository.ServiceRepository;

@Service
public class QueuemanagerService {

	
	@Autowired
	private QueueManagerRepository queueManagerRepository;
	@Autowired
	private LocationQueueManagerAssociationRepository locationQueueManagerAssociationRepository;
	
	@Autowired
	private QueueRepository queueRepository;

	@Autowired
	private ServiceRepository serviceRepository;
	
	public QueueManager save(QueueManager queueManager) {
		return queueManagerRepository.save(queueManager);
	}

	public LocationQueueManagerAssociation save(LocationQueueManagerAssociation queueManager) {
		return locationQueueManagerAssociationRepository.save(queueManager);
	}

	public Queue save(Queue queue) {
		return queueRepository.save(queue);
	}

	public com.smartdude.entity.Service saveService(com.smartdude.entity.Service service) {
		return serviceRepository.save(service);
	}

	public List<QueueManager> findQManagerByVendorID(Integer vendorID) {
		
		return queueManagerRepository.findByVendorVendorid(vendorID);
	}
	
}
