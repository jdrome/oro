package com.oroapp.oro.bootstrap;

import com.oroapp.oro.entity.Budget;
import com.oroapp.oro.entity.Category;
import com.oroapp.oro.entity.Transaction;
import com.oroapp.oro.entity.User;
import com.oroapp.oro.repository.BudgetRepository;
import com.oroapp.oro.repository.CategoryRepository;
import com.oroapp.oro.repository.TransactionRepository;
import com.oroapp.oro.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
@Profile("dev")
public class TestDataLoader {

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepo,
                                               CategoryRepository categoryRepo,
                                               BudgetRepository budgetRepo,
                                               TransactionRepository transactionRepo) {
        return args -> {

            // Clear previous test data
            userRepo.deleteAll();
            categoryRepo.deleteAll();

            // Create a user
            User user = new User();
            user.setUsername("testuser");
            user.setPassword("password"); // TODO: hash later
            user = userRepo.save(user);

            // Create a category
            Category food = new Category();
            food.setName("Food");
            food = categoryRepo.save(food);

            // Create a budget
            Budget foodBudget = new Budget();
            foodBudget.setUser(user);
            foodBudget.setCategory(food);
            foodBudget.setLimitAmount(new BigDecimal("300.00"));
            budgetRepo.save(foodBudget);

            // Create a few transactions
            Transaction t1 = new Transaction();
            t1.setUser(user);
            t1.setCategory(food);
            t1.setAmount(new BigDecimal("25.50"));
            t1.setDate(LocalDate.now().minusDays(1));
            t1.setDescription("Groceries");
            transactionRepo.save(t1);

            Transaction t2 = new Transaction();
            t2.setUser(user);
            t2.setCategory(food);
            t2.setAmount(new BigDecimal(18.75));
            t2.setDate(LocalDate.now().minusDays(1));
            t2.setDescription("Lunch");
            transactionRepo.save(t2);

            System.out.println("Test data loaded! ✅");
        };
    }
}
