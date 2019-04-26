package com.smartdude.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartdude.dto.QueueManagerDTO;
import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.Queue;
import com.smartdude.entity.QueueManager;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.mapper.QueueManagerMapper;
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
	@Autowired
	private QueueManagerMapper queueManagerMapper;

	public QueueManagerDTO save(QueueManager queueManager) throws EntitySaveException {
		try {
			String password = SmartDudeUtilityService.buildTemPassword(queueManager.getQueuemanagername(),
					queueManager.getQmanagerphonenumber(), "QM");
			queueManager.setQmanagerpassword(password);
			queueManager.setCreatedtimestamp(LocalDateTime.now());
			queueManager.setUpdatedtimestamp(LocalDateTime.now());
			QueueManager savedQueueManager = queueManagerRepository.save(queueManager);
			QueueManagerDTO queueManagerDTO = queueManagerMapper.queueManagerToQueueManagerDTO(savedQueueManager);
			return queueManagerDTO;
		} catch (Exception e) {
			throw new EntitySaveException("Error Occured While Creating The Vendor. Please Try Again.");
		}
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
			queueManager.setCreatedtimestamp(LocalDateTime.now());
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
		return queueManagerRepository.findByQueuemanageridAndVendorVendorid(qmanagerID, vendorID);
	}

	public LocationQueueManagerAssociation updateAssociation(Integer vendorID, Integer associateLocationQmanagerID,
			Boolean status) {
		Optional<LocationQueueManagerAssociation> locationQueueManagerAssociation = locationQueueManagerAssociationRepository
				.findById(associateLocationQmanagerID);
		if (locationQueueManagerAssociation.isPresent()) {
			locationQueueManagerAssociation.get().setLocqmanagerassociationid(associateLocationQmanagerID);
			locationQueueManagerAssociation.get().setActivestatus(status);
			locationQueueManagerAssociation.get().setUpdatedtimestamp(LocalDateTime.now());
			return locationQueueManagerAssociationRepository.save(locationQueueManagerAssociation.get());
		}
		return null;
	}

	public LocationQueueManagerAssociation findAssocationBQMID(Integer qmID) {
		// TODO Auto-generated method stub
		return locationQueueManagerAssociationRepository.findByQmanagerid(qmID);
	}

	public LocationQueueManagerAssociation findByVendorID(Integer vendorID) {
		// TODO Auto-generated method stub
		return locationQueueManagerAssociationRepository.findByVendorVendorid(vendorID);
	}

}
