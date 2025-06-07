package com.oroapp.oro.service;

import com.oroapp.oro.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    User findById(Long id);
}
