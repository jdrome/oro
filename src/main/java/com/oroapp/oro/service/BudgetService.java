package com.oroapp.oro.service;

import com.oroapp.oro.entity.Budget;
import com.oroapp.oro.entity.Category;
import com.oroapp.oro.entity.User;

import java.util.List;
import java.util.Optional;

public interface BudgetService {
    Budget saveBudget(Budget budget);
    List<Budget> getBudgetsByUser(User user);
    Budget getBudgetByUserAndCategory(User user, Category category);
}
