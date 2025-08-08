package com.mauricio.pc.user_service.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String email;
    private String avatarUrl;
    private String role;
}