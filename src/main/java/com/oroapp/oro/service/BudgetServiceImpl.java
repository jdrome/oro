package com.oroapp.oro.service;

import com.oroapp.oro.entity.Budget;
import com.oroapp.oro.entity.Category;
import com.oroapp.oro.entity.User;
import com.oroapp.oro.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

    public final BudgetRepository budgetRepo;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    @Override
    public Budget saveBudget(Budget budget) {
        return budgetRepo.save(budget);
    }

    @Override
    public List<Budget> getBudgetsByUser(User user) {
        return budgetRepo.findByUser(user);
    }

    @Override
    public Optional<Budget> getBudgetByUserAndCategory(User user, Category category) {
        return budgetRepo.findByUserAndCategory(user, category);
    }
}
