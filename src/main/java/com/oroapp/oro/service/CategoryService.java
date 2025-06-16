package com.oroapp.oro.service;

import com.oroapp.oro.entity.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    Category findByName(String name);
    Category findById(Long id);
    List<Category> findAll();
}
