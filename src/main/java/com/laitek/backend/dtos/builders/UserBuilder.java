package com.laitek.backend.dtos.builders;

import com.laitek.backend.dtos.UserDTO;
import com.laitek.backend.entities.User;

public class UserBuilder {

    private UserBuilder() {
    }

    public static UserDTO toUserDTO(User user) {
        if (user == null)
            return null;
        return UserDTO.builder().
                id(user.getId()).
                username(user.getUsername()).
                password(user.getPassword()).
                name(user.getName()).
                is_admin(user.getIs_admin()).
                build();
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null)
            return null;
        return User.builder().
                id(userDTO.getId()).
                username(userDTO.getUsername()).
                password(userDTO.getPassword()).
                name(userDTO.getName()).
                is_admin(userDTO.getIs_admin()).
                build();
    }
}
