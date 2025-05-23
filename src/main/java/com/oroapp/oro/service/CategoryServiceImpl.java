package com.oroapp.oro.service;

import com.oroapp.oro.entity.Category;
import com.oroapp.oro.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepo.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
