package com.oroapp.oro.service;

import com.oroapp.oro.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category saveCategory(Category category);
    Category findByName(String name);
    List<Category> findAll();
}
