package com.example.demospring.controller;

import com.example.demospring.dto.BlogRequest;
import com.example.demospring.entity.Blog;
import com.example.demospring.serviceImpl.BlogServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@AllArgsConstructor
public class BlogController {
// FORM BASED AUTHENTICATION

    // open api - swagger
    private final BlogServiceImpl manager;

    @GetMapping
    public List<Blog> getAll(){
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public Blog getById(@PathVariable int id){
        return manager.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveBlog(@RequestBody BlogRequest request){
        manager.saveBlog(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        manager.deleteBlog(id);
    }

}
