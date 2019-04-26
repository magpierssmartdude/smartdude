package com.smartdude.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.smartdude.dto.LocationQueueManagerAssociationDTO;
import com.smartdude.dto.QueueManagerDTO;
import com.smartdude.entity.LocationQueueManagerAssociation;
import com.smartdude.entity.Queue;
import com.smartdude.entity.QueueManager;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.ParameterNotFound;
import com.smartdude.mapper.LocationQueueManagerAssociationMapper;
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
	@Autowired
	private LocationQueueManagerAssociationMapper locationQueueManagerAssociationMapper;

	@Transactional
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

	@Transactional
	public QueueManagerDTO update(QueueManager queueManager, Integer qManagerID)
			throws ParameterNotFound, EntitySaveException {
		if (queueManager != null && qManagerID != null) {
			try {
				queueManager.setQueuemanagerid(qManagerID);
				Optional<QueueManager> queueManagerChecking = queueManagerRepository.findById(qManagerID);
				if (queueManagerChecking.isPresent()) {
					QueueManager savedQueueManager = queueManagerRepository.save(queueManager);
					QueueManagerDTO queueManagerDTO = queueManagerMapper
							.queueManagerToQueueManagerDTO(savedQueueManager);
					return queueManagerDTO;
				} else {
					throw new EntityNotFoundException("Queue Manager Details Not Found For The Given Queue Manager ID");
				}
			} catch (Exception e) {
				throw new EntitySaveException("Error Occured While Updating The Queue Manager. Please Try Again.");
			}
		} else {
			throw new ParameterNotFound("Please Provide All The Required Parameters To Proceed The Request");
		}
	}

	@Transactional
	public LocationQueueManagerAssociationDTO save(LocationQueueManagerAssociation queueManager, Integer vendorID)
			throws ParameterNotFound, EntitySaveException {
		try {
			if (vendorID != null && vendorID != 0) {
				queueManager.setCreatedtimestamp(LocalDateTime.now());
				LocationQueueManagerAssociation loctaionqueueManager = locationQueueManagerAssociationRepository
						.save(queueManager);
				LocationQueueManagerAssociationDTO locationQueueManagerAssociationDTO = locationQueueManagerAssociationMapper
						.locationQueueManagerAssociationtoLocationQueueManagerAssociationDTO(loctaionqueueManager);
				return locationQueueManagerAssociationDTO;
			} else {
				throw new ParameterNotFound("Not A Valid Vendor ID. Please Provide a Valid Vendor ID");
			}
		} catch (Exception e) {
			throw new EntitySaveException(
					"Error Occured While Saving Location Queue Manager Associaton Details. Please Try Again.");
		}
	}

	public Queue save(Queue queue) {
		queue.setCreateddatetime(LocalDateTime.now());

		return queueRepository.save(queue);
	}

	public com.smartdude.entity.Service saveService(com.smartdude.entity.Service service) {
		return serviceRepository.save(service);
	}

	@Transactional
	public List<QueueManagerDTO> findQManagerByVendorID(Integer vendorID) throws EntityNotFoundException {
		List<QueueManager> managerList = queueManagerRepository.findByVendorVendorid(vendorID);
		if (CollectionUtils.isEmpty(managerList)) {
			throw new EntityNotFoundException("Queue Manager Details Not Found For The Given Vendor ID " + vendorID);
		} else {
			List<QueueManagerDTO> dtoList = new ArrayList<>();
			dtoList = queueManagerMapper.queueManagerListToQueueManagerDtoList(managerList);
			return dtoList;
		}
	}

	public QueueManagerDTO findQManagerByVendorIDAndQmID(Integer vendorID, Integer qmanagerID)
			throws EntityNotFoundException {
		Optional<QueueManager> queueManager = queueManagerRepository.findByQueuemanageridAndVendorVendorid(qmanagerID,
				vendorID);
		if (queueManager.isPresent()) {
			QueueManagerDTO queueManagerDTO = queueManagerMapper.queueManagerToQueueManagerDTO(queueManager.get());
			return queueManagerDTO;
		} else {
			throw new EntityNotFoundException("Queue Manager Details Not Found For The Given Vendor ID " + vendorID
					+ " And Queue Manager ID " + qmanagerID);
		}
	}

	@Transactional
	public LocationQueueManagerAssociationDTO updateAssociation(Integer vendorID, Integer associateLocationQmanagerID,
			Boolean status) throws EntityNotFoundException, EntitySaveException {
		Optional<LocationQueueManagerAssociation> locationQueueManagerAssociation = locationQueueManagerAssociationRepository
				.findById(associateLocationQmanagerID);
		if (locationQueueManagerAssociation.isPresent()) {
			locationQueueManagerAssociation.get().setLocqmanagerassociationid(associateLocationQmanagerID);
			locationQueueManagerAssociation.get().setActivestatus(status);
			locationQueueManagerAssociation.get().setUpdatedtimestamp(LocalDateTime.now());
			try {
				LocationQueueManagerAssociation savedLocationQueueManagerAssociation = locationQueueManagerAssociationRepository
						.save(locationQueueManagerAssociation.get());
				LocationQueueManagerAssociationDTO dto = locationQueueManagerAssociationMapper
						.locationQueueManagerAssociationtoLocationQueueManagerAssociationDTO(
								savedLocationQueueManagerAssociation);
				return dto;
			} catch (Exception e) {
				throw new EntitySaveException(
						"Error Occured While Updating Location Queue Manager Association Details. Please Try Again");
			}
		} else {
			throw new EntityNotFoundException(
					"Location Queue Manager Details Not Found For The Provided Location Queue Manager Association ID "
							+ associateLocationQmanagerID);
		}
	}

	public LocationQueueManagerAssociationDTO findAssocationBQMID(Integer qmID) throws EntityNotFoundException {
		Optional<LocationQueueManagerAssociation> locationQueueManagerAssociation = locationQueueManagerAssociationRepository
				.findByQmanagerid(qmID);
		if (locationQueueManagerAssociation.isPresent()) {
			LocationQueueManagerAssociationDTO locationQueueManagerAssociationDTO = locationQueueManagerAssociationMapper
					.locationQueueManagerAssociationtoLocationQueueManagerAssociationDTO(
							locationQueueManagerAssociation.get());
			return locationQueueManagerAssociationDTO;
		} else {
			throw new EntityNotFoundException(
					"Location Queue Manager Details Not Found For The Given Queue Manager ID " + qmID);
		}
	}

	public LocationQueueManagerAssociationDTO findByVendorID(Integer vendorID) throws EntityNotFoundException {
		Optional<LocationQueueManagerAssociation> locationQueueManagerAssociation = locationQueueManagerAssociationRepository
				.findByVendorVendorid(vendorID);
		if (locationQueueManagerAssociation.isPresent()) {
			LocationQueueManagerAssociationDTO locationQueueManagerAssociationDTO = locationQueueManagerAssociationMapper
					.locationQueueManagerAssociationtoLocationQueueManagerAssociationDTO(
							locationQueueManagerAssociation.get());
			return locationQueueManagerAssociationDTO;
		} else {
			throw new EntityNotFoundException(
					"Location Queue Manager Association Not Found For The Provided Vendor ID " + vendorID);
		}
	}

	public Queue update(Queue queue, Integer queueid) {
		if (queueid != null && queueid != 0) {
			queue.setQueueid(queueid);
			queue.setLastupdatetime(LocalDateTime.now());
		}
		return null;
	}

	public List<Queue> findQByQManagerAssociationID(Integer qmID) {
		return queueRepository.findByLocationQueueManagerAssociationLocqmanagerassociationid(qmID);
	}

	public Queue findQByQueueidAndQManagerAssociationID(Integer qmID, Integer queueid) {
		return queueRepository.findByQueueidAndLocationQueueManagerAssociationLocqmanagerassociationid(queueid, qmID);
	}

	public com.smartdude.entity.Service updateService(com.smartdude.entity.Service service, Integer serviceid) {
		service.setServiceid(serviceid);
		return serviceRepository.save(service);
	}

	public List<com.smartdude.entity.Service> getServiceByQueueID(Integer queueid) {
		// TODO Auto-generated method stub
		return serviceRepository.findByQueueQueueid(queueid);
	}

	public com.smartdude.entity.Service getServiceByQueueIDAndServiceID(Integer queueid, Integer serviceID) {
		// TODO Auto-generated method stub
		return serviceRepository.findByServiceidAndQueueQueueid(serviceID, queueid);
	}

}
