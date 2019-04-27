package com.smartdude.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.QueueDTO;
import com.smartdude.entity.Queue;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QueueMapper {

	QueueDTO queueToQueueDTO (Queue queue);
	
	List<QueueDTO> queueDTOListToQueueList (List<Queue> queueList);
}
