package com.smartdude.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.LocationQueueManagerAssociationDTO;
import com.smartdude.entity.LocationQueueManagerAssociation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationQueueManagerAssociationMapper {

	public LocationQueueManagerAssociationDTO locationQueueManagerAssociationtoLocationQueueManagerAssociationDTO(
			LocationQueueManagerAssociation locationQueueManagerAssociation);

}
