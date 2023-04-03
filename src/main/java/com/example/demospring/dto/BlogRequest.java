package com.example.demospring.dto;


public record BlogRequest(
        String header,

        String content,

        UserBlogRequest user
) {
}
