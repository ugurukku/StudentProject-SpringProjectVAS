package com.example.demospring.dto;

import com.example.demospring.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOManager implements Function<User,UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getFullName(),
                user.getAge());
    }
}
