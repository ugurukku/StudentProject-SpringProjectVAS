package com.example.demospring.mapper;

import com.example.demospring.dto.BlogRequest;
import com.example.demospring.entity.Blog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    Blog blogRequestToEntity(BlogRequest request);

}
