package com.example.demospring.service.impl;


import com.example.demospring.dto.UserDTO;
import com.example.demospring.entity.User;
import com.example.demospring.exception.UserNotFoundException;
import com.example.demospring.mapper.UserMapper;
import com.example.demospring.repository.UserRepository;
import com.example.demospring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public UserDTO getById(int id) {
        return userRepository.findById(id)
                .stream()
                .map(userMapper::toUserDto)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User tapilmadi"));

    }

    @Override
    public User saveUser(UserDTO dto) {
        return userRepository.save(userMapper.toEntity(dto));
    }

    @Override
    public void deleteUser(int id) {
       userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllPage(int page, int count) {

      Page<User> users = userRepository.findAll(PageRequest.of(page,count));

     return   users
              .getContent()
              .stream()
              .map(userMapper::toUserDto)
              .toList();

    }
}
