package com.oroapp.oro.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transaction {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double amount;
    private LocalDate date;

    // Relationship Mappings
    @ManyToOne
    @JoinColumn(name = "category_id") // Explicit name for the FK column for Category
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id") // Explicit name for the FK column for User
    private User user;

    // Constructors
    public Transaction() {}

    public Transaction(String description, Double amount, LocalDate date, Category category, User user) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount;}

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}