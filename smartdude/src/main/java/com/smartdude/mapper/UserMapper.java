package com.smartdude.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.UserDTO;
import com.smartdude.entity.User;
import com.smartdude.entity.Vendor;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


	User userDTOToUser(UserDTO dto);

	
	@Mapping(target="username",source="vendorname")
	@Mapping(target="clientcode",source="vendorcode")
	@Mapping(target="clientcode",source="vendorcode")
	User vendorToUser(Vendor vendor);
}
