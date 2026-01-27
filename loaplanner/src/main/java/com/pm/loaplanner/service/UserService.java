package com.pm.loaplanner.service;

import com.pm.loaplanner.dto.UserRequestDTO;
import com.pm.loaplanner.dto.UserResponseDTO;
import com.pm.loaplanner.exception.ApiException;
import com.pm.loaplanner.mapper.UserMapper;
import com.pm.loaplanner.model.User;
import com.pm.loaplanner.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        // Verificação de email
        String emailRegex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        if (!Pattern.matches(emailRegex, userRequestDTO.getEmail())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Email must be valid!");
        }

        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Email address already in use!");
        }

        // Verificações Password
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$";
        if (!Pattern.matches(passwordRegex, userRequestDTO.getPassword())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Password must contain 8 characters, including an uppercase letter, a lowercase letter, a number, and a special character!");
        }

        if (!userRequestDTO.getPassword().equals(userRequestDTO.getConfirmPassword())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Passwords do not match!");
        }

        // Verificações Username
        if (userRequestDTO.getUsername().length() < 3) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Username must be at least 3 characters long!");
        }

        User newUser = UserMapper.toModel(userRequestDTO);
        newUser.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        User savedUser = userRepository.save(newUser);

        return UserMapper.toDTO(savedUser);
    }
}
