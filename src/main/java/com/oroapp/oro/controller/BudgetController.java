package com.oroapp.oro.controller;

import com.oroapp.oro.entity.Budget;
import com.oroapp.oro.entity.Category;
import com.oroapp.oro.entity.User;
import com.oroapp.oro.service.BudgetService;
import com.oroapp.oro.service.CategoryService;
import com.oroapp.oro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
    private final BudgetService budgetService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public BudgetController(BudgetService budgetService, UserService userService, CategoryService categoryService) {
        this.budgetService = budgetService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    // POST /api/budgets
    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        Budget created = budgetService.saveBudget(budget);
        return ResponseEntity.ok(created);
    }

    // GET /api/budgets/user/{user}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Budget>> getBudgetsByUser(@PathVariable Long userId) {
        User user = userService.findById(userId);
        List<Budget> found = budgetService.getBudgetsByUser(user);
        return ResponseEntity.ok(found);
    }

    // GET /api/budgets/user/{user}/category/{category}
    @GetMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<Budget> getBudgetByUserAndCategory(@PathVariable Long userId, @PathVariable Long categoryId) {
        User user = userService.findById(userId);
        Category category = categoryService.findById(categoryId);
        Budget found = budgetService.getBudgetByUserAndCategory(user, category);
        return ResponseEntity.ok(found);
    }
}
