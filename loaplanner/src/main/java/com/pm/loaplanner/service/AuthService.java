package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.Login.LoginRequestDTO;
import com.pm.loaplanner.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<String> token = userService
            .findByEmail(loginRequestDTO.getEmail())
            .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword()))
            .map(u -> jwtUtil.generateToken(u.getId().toString(), u.getEmail(), u.getRole(), u.getUsername()));

        return token;
    }
}
