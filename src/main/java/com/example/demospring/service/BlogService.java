package com.example.demospring.service;

import com.example.demospring.dto.BlogRequest;
import com.example.demospring.entity.Blog;
import com.example.demospring.entity.User;

import java.util.List;

public interface BlogService {

    List<Blog> getAll();


    Blog getById(int id);

    void saveBlog(BlogRequest request);

    void deleteBlog(int id);

}
