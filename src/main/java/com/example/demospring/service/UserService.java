package com.example.demospring.service;

import com.example.demospring.dto.RegisterRequest;
import com.example.demospring.dto.UserRequestResponse;
import com.example.demospring.dto.UserPageResponse;
import com.example.demospring.entity.User;

public interface UserService {

    UserPageResponse getAll(int page, int count);

    UserRequestResponse getById(int id);


    User saveUser(UserRequestResponse user);

    void deleteUser(int id);

    User getUserByEmail(String email);

    void register(RegisterRequest request);
}
