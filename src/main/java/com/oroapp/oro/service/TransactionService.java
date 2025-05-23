package com.oroapp.oro.service;

import com.oroapp.oro.entity.Transaction;
import com.oroapp.oro.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getTransactionsByUser(User user);
    List<Transaction> getTransactionsBetweenDates(User user, LocalDate start, LocalDate end);
}
