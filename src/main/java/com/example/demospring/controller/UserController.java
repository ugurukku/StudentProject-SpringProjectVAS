package com.example.demospring.controller;


import com.example.demospring.dto.UserDTO;
import com.example.demospring.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public List<UserDTO> getAll(){
        return userServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable int id){
        return userServiceImpl.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDTO user){
        userServiceImpl.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userServiceImpl.deleteUser(id);
    }
}
