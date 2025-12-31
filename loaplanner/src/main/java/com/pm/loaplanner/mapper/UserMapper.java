package com.pm.loaplanner.mapper;

import com.pm.loaplanner.dto.UserRequestDTO;
import com.pm.loaplanner.dto.UserResponseDTO;
import com.pm.loaplanner.model.User;

public class UserMapper {
    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(user.getId().toString());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    public static User toModel(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setRole("USER");   // Default Value
        return user;
    }
}
