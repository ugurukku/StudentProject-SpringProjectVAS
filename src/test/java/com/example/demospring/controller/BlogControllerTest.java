package com.example.demospring.controller;

import com.example.demospring.dto.BlogRequest;
import com.example.demospring.dto.UserBlogRequest;
import com.example.demospring.entity.Blog;
import com.example.demospring.entity.User;
import com.example.demospring.exception.UserNotFoundException;
import com.example.demospring.service.BlogService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class BlogControllerTest {

    private MockMvc mvc;

    @MockBean
    private BlogService service;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String BASE_URL = "/api/blogs";

    @PostConstruct
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void getAll() throws Exception {


        List<Blog> expectedBlogs = Arrays.asList(

                Blog
                        .builder()
                        .id(1L)
                        .user(new User())
                        .header("header")
                        .content("content")
                        .build(),
                Blog
                        .builder()
                        .id(1L)
                        .user(new User())
                        .header("header")
                        .content("content")
                        .build());

        when(service.getAll()).thenReturn(expectedBlogs);

        MvcResult mvcResult = mvc
                .perform(
                        get(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String resultContent = mvcResult.getResponse().getContentAsString();
        List<Blog> responseBlogs = objectMapper.readValue(resultContent, new TypeReference<List<Blog>>() {
        });

        assertEquals(expectedBlogs, responseBlogs);


    }

    @Test
    void getById() throws Exception {

        Blog expectedBlog = Blog
                .builder()
                .id(1L)
                .user(new User())
                .header("header")
                .content("content")
                .build();

        when(service.getById(1)).thenReturn(expectedBlog);

        MvcResult mvcResult = mvc
                .perform(get(BASE_URL.concat("/1"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String resultContent = mvcResult.getResponse().getContentAsString();
        Blog responseBlog = objectMapper.readValue(resultContent, Blog.class);


        assertEquals(expectedBlog, responseBlog);


    }

    @Test
    void saveBlog() throws Exception {

        BlogRequest blogRequest = new BlogRequest("header", "content", new UserBlogRequest(1L));

        String jsonBlogRequest = objectMapper.writeValueAsString(blogRequest);

        Mockito.doThrow(new UserNotFoundException("User not found for id 1")).when(service).saveBlog(blogRequest);

        MvcResult mvcResult = mvc
                .perform(post(BASE_URL).contentType(MediaType.APPLICATION_JSON).content(jsonBlogRequest))
                .andReturn();


        assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());

    }

    @Test
    void deleteUser() {
    }
}