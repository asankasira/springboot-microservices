package org.asanka.javaguide.mapper;

import org.asanka.javaguide.dto.UserDTO;
import org.asanka.javaguide.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "surname", source = "lastName")
    UserDTO mapToUserDto(User user);

    @Mapping(target = "lastName", source = "surname")
    User mapToUser(UserDTO dto);
}
