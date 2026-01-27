package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.LoginRequestDTO;
import com.pm.loaplanner.dto.LoginResponseDTO;

import com.pm.loaplanner.dto.UserRequestDTO;
import com.pm.loaplanner.dto.UserResponseDTO;
import com.pm.loaplanner.exception.ApiException;
import com.pm.loaplanner.service.AuthService;
import com.pm.loaplanner.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @Operation(summary = "Generate token on user login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Optional<String> tokenOptional = authService.authenticate(loginRequestDTO);

        if (tokenOptional.isEmpty()) {
            throw new ApiException(HttpStatus.UNAUTHORIZED, "User does not exist!");
        }

        String token = tokenOptional.get();
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO createdUser = userService.createUser(userRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
