package com.example.demospring.controller;


import com.example.demospring.dto.UserDTO;
import com.example.demospring.entity.User;
import com.example.demospring.manager.UserManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserManager userManager;

    @GetMapping
    public List<UserDTO> getAll(){
        return userManager.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable int id){
        return userManager.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDTO user){
        userManager.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userManager.deleteUser(id);
    }
}
