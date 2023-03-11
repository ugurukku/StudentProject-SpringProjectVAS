package com.example.demospring.repository;

import com.example.demospring.entity.Blog;
import com.example.demospring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

}
