package com.example.demospring.mapper;

import com.example.demospring.dto.UserRequestResponse;
import com.example.demospring.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequestResponse toUserDto(User user);

    User toEntity(UserRequestResponse userRequestResponse);

}
