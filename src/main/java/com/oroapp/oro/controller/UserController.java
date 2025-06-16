package com.oroapp.oro.controller;

import com.oroapp.oro.entity.User;
import com.oroapp.oro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /api/users
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = userService.saveUser(user);
        return ResponseEntity.ok(created);
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // Locates user, saves to found
        User found = userService.findById(id);

        // Return 200 OK when user is found
        return ResponseEntity.ok(found);
    }

    // GET /api/users/username/{username}
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        // Locates user, saves to found
        User found = userService.findByUsername(username);

        // Return 200 OK when user is found
        return ResponseEntity.ok(found);
    }
}
