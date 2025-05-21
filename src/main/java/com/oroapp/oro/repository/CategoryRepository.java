package com.oroapp.oro.repository;

import com.oroapp.oro.entity.Category;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findByName(String name);
}
