package com.example.demospring.mapper;

import com.example.demospring.dto.UserDTO;
import com.example.demospring.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toUserDto(User user);

}
