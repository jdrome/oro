package com.oroapp.oro.repository;

import com.oroapp.oro.entity.Budget;
import com.oroapp.oro.entity.Category;
import com.oroapp.oro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUser(User user);
    Optional<Budget> findByUserAndCategory(User user, Category category);
}
