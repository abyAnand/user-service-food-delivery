package com.delivery.userservice.mapper;

import com.delivery.userservice.dto.UserDTO;
import com.delivery.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO user);
    UserDTO mapUserToUserDTO(User user);
}
