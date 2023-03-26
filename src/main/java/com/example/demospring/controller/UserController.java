package com.example.demospring.controller;


import com.example.demospring.dto.UserDTO;
import com.example.demospring.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        logger.info("User getAll accepted request");
        return userServiceImpl.getAll();
    }

    @GetMapping("/page")
    public List<UserDTO> getAllPage(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "count") int count
    ){
        return userServiceImpl.getAllPage(page,count);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable int id) {
        return userServiceImpl.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDTO user) {
        userServiceImpl.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userServiceImpl.deleteUser(id);
    }
}
