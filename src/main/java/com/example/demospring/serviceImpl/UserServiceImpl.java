package com.example.demospring.serviceImpl;


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

    private final UserMapper mapper;


    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toUserDto)
                .toList();
    }

    @Override
    public UserDTO getById(int id) {
        return userRepository.findById(id)
                .stream()
                .map(mapper::toUserDto)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User tapilmadi"));

    }

    @Override
    public User saveUser(UserDTO dto) {
        return userRepository.save(mapper.toEntity(dto));
    }

    @Override
    public void deleteUser(int id) {
       userRepository.deleteById(id);
    }

}
