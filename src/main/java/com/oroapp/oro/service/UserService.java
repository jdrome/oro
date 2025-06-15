package com.oroapp.oro.service;

import com.oroapp.oro.entity.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    User findById(Long id);
}
