package com.example.demospring.serviceImpl;

import com.example.demospring.dto.BlogRequest;
import com.example.demospring.entity.Blog;
import com.example.demospring.mapper.BlogMapper;
import com.example.demospring.repository.BlogRepository;
import com.example.demospring.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogMapper mapper;
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
    public void saveBlog(BlogRequest request) {
        repository.save(mapper.blogRequestToEntity(request));
    }

    @Override
    public void deleteBlog(int id) {
        repository.deleteById(id);
    }
}
