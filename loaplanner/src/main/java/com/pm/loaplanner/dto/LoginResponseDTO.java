package com.pm.loaplanner.dto;

import lombok.Getter;

@Getter
public class LoginResponseDTO {
    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
