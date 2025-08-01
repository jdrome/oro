package com.oroapp.oro.controller;

import com.oroapp.oro.dto.UserDTO;
import com.oroapp.oro.entity.User;
import com.oroapp.oro.mapper.UserMapper;
import com.oroapp.oro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper =  userMapper;
    }

    // POST /api/users
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User userToSave = userMapper.toEntity(userDTO);
        User savedUser = userService.saveUser(userToSave);
        UserDTO responseDTO = userMapper.toDTO(savedUser);
        return ResponseEntity.ok(responseDTO);
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        // Locates user, saves to found
        User found = userService.findById(id);

        // Return 200 OK when user is found
        return ResponseEntity.ok(userMapper.toDTO(found));
    }

    // GET /api/users/username/{username}
    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        // Locates user, saves to found
        User found = userService.findByUsername(username);

        // Return 200 OK when user is found
        return ResponseEntity.ok(userMapper.toDTO(found));
    }
}
