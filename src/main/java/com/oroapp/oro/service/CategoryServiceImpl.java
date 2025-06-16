package com.oroapp.oro.service;

import com.oroapp.oro.entity.Category;
import com.oroapp.oro.exception.NotFoundException;
import com.oroapp.oro.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Category findByName(String name) {
        return categoryRepo.findByName(name)
                .orElseThrow(() -> new NotFoundException("Category not found with name: " + name));
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
