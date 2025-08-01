package com.oroapp.oro.mapper;

import com.oroapp.oro.dto.UserDTO;
import com.oroapp.oro.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if (user == null) return null;

        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail()
        );
    }

    // Expect JPA to handle ID
    public User toEntity(UserDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return user;
    }
}
