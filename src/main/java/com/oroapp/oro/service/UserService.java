package com.oroapp.oro.service;

import com.oroapp.oro.entity.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
}
