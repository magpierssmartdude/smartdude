package com.smartdude.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.UserDTO;
import com.smartdude.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


	User userDTOToUser(UserDTO dto);
}
