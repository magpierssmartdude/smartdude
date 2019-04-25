package com.smartdude.service;

import java.time.LocalDateTime;
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
import com.smartdude.utility.SmartDudeUtilityService;

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

		String password = SmartDudeUtilityService.buildTemPassword(queueManager.getQueuemanagername(),
				queueManager.getQmanagerphonenumber(), "QM");
		queueManager.setQmanagerpassword(password);
		queueManager.setCreatedtimestamp(LocalDateTime.now());
		queueManager.setUpdatedtimestamp(LocalDateTime.now());
		return queueManagerRepository.save(queueManager);

	}

	public QueueManager update(QueueManager queueManager, Integer qManagerID) {

		if (queueManager != null && qManagerID != null) {
			queueManager.setQueuemanagerid(qManagerID);

			return queueManagerRepository.save(queueManager);
		} else {
			// need to throw exception
			return null;

		}
	}

	public LocationQueueManagerAssociation save(LocationQueueManagerAssociation queueManager, Integer vendorID) {
		if (vendorID != null && vendorID != 0) {
			return locationQueueManagerAssociationRepository.save(queueManager);
		} else {
			// throws exception
			return null;
		}
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

	public QueueManager findQManagerByVendorIDAndQmID(Integer vendorID, Integer qmanagerID) {
		return queueManagerRepository.findByQueuemanageridAndVendorVendorid(qmanagerID,vendorID);
	}

}
