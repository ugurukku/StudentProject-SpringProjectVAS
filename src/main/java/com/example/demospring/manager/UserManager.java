package com.example.demospring.manager;


import com.example.demospring.dto.UserDTO;
import com.example.demospring.dto.UserDTOManager;
import com.example.demospring.dto.UserMapper;
import com.example.demospring.entity.User;
import com.example.demospring.exception.UserNotFoundException;
import com.example.demospring.repository.UserRepository;
import com.example.demospring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserDTOManager userDTOManager;

    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userDTOManager)
                .toList();
    }

    @Override
    public UserDTO getById(int id) {
        return userRepository.findById(id)
                .stream()
                .map(userDTOManager)
                .findFirst().orElseThrow(()->new UserNotFoundException("User tapilmadi"));

    }

    @Override
    public User saveUser(UserDTO dto) {
        return userRepository.save(userMapper.apply(dto));
    }

    @Override
    public void deleteUser(int id) {
       userRepository.deleteById(id);
    }
}
