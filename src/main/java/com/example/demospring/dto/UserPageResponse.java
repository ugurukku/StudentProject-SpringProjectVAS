package com.example.demospring.dto;

import java.util.List;

public record UserPageResponse(
        List<UserDTO> users,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}
