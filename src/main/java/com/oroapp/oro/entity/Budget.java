package com.oroapp.oro.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Budget {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal limitAmount;

    // Relationship Mappings
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Constructors
    public Budget() { }
    public Budget(BigDecimal limitAmount, User user, Category category) {
        this.limitAmount = limitAmount;
        this.user = user;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getLimitAmount() { return limitAmount; }
    public void setLimitAmount(BigDecimal limitAmount) { this.limitAmount = limitAmount; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
