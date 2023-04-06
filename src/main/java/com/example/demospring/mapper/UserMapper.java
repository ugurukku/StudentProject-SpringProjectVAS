package com.example.demospring.mapper;

import com.example.demospring.dto.RegisterRequest;
import com.example.demospring.dto.UserRequestResponse;
import com.example.demospring.entity.User;
import com.example.demospring.security.MyUserDetails;
import com.example.demospring.security.MyUserDetailsService;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequestResponse toUserDto(User user);

    User toEntity(UserRequestResponse userRequestResponse);

    MyUserDetails toMyUserDetails(User user);

    User toUserFromRegisterRequest(RegisterRequest request);

}
