package com.example.demospring.service;

import com.example.demospring.dto.UserDTO;
import com.example.demospring.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> getAll();

    UserDTO getById(int id);

    User saveUser(User user);

    void deleteUser(int id);
}
