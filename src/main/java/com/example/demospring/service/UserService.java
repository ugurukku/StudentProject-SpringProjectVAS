package com.example.demospring.service;

import com.example.demospring.dto.UserDTO;
import com.example.demospring.dto.UserPageResponse;
import com.example.demospring.entity.User;

import java.util.List;

public interface UserService {

    UserPageResponse getAll(int page, int count);

    UserDTO getById(int id);

    User saveUser(UserDTO user);

    void deleteUser(int id);

}
