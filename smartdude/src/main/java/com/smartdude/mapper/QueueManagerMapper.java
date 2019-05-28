package com.smartdude.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.QueueManagerDTO;
import com.smartdude.entity.QueueManager;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QueueManagerMapper {

	//@Mapping(target="vendorid",source="vendor.vendorid")
	public QueueManagerDTO queueManagerToQueueManagerDTO(QueueManager queueManager);

	public List<QueueManagerDTO> queueManagerListToQueueManagerDtoList(List<QueueManager> managerList);
}
