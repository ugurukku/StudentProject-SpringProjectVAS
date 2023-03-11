package com.example.demospring.service.impl;

import com.example.demospring.entity.Blog;
import com.example.demospring.repository.BlogRepository;
import com.example.demospring.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository repository;

    @Override
    public List<Blog> getAll() {
        return repository.findAll();
    }


    @Override
    public Blog getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveBlog(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        repository.deleteById(id);
    }
}
