package com.example.demospring.controller;

import com.example.demospring.dto.BlogRequest;
import com.example.demospring.entity.Blog;
import com.example.demospring.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@AllArgsConstructor
public class BlogController {

    private final BlogService service;

    @GetMapping
    public List<Blog> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Blog getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveBlog(@RequestBody BlogRequest request){
        service.saveBlog(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteBlog(id);
    }

}
