package com.example.demospring.mapper;

import com.example.demospring.dto.UserDTO;
import com.example.demospring.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDto(User user);

    User toEntity(UserDTO userDTO);

}
