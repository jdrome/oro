package com.oroapp.oro.entity;

import com.google.common.annotations.VisibleForTesting;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table( name = "users" )
public class User {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password; // passwords will be hashed prior to storing

    // Relationship Mappings
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Budget> budgets;

    // Default Constructor(JPA)
    public User() {}

    // Application Constructor
    public User(String firstName, String lastName, String name, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = name;
        this.email = email;
    }

    // Test-only Constructor
    @VisibleForTesting
    public User(Long id, String firstName, String lastName, String username, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUsername() { return username; }
    public void setUsername(String name) { this.username = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }

    public List<Budget> getBudgets() { return budgets; }
    public void setBudgets(List<Budget> budgets) { this.budgets = budgets; }
}
