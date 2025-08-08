package com.mauricio.pc.user_service.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String email;
    private String avatarUrl;
    private String role;
}
