package com.example.demospring.dto;

import com.example.demospring.entity.User;

import java.util.function.Function;

public class UserMapper implements Function<UserDTO,User> {
    @Override
    public User apply(UserDTO dto) {
        return new User(null, dto.fullName(), dto.age());
    }
}
