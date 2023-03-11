package com.example.demospring.dto;

import com.example.demospring.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserMapper implements Function<UserDTO,User> {
    @Override
    public User apply(UserDTO dto) {
        return new User(dto.fullName(), dto.age());
    }
}
