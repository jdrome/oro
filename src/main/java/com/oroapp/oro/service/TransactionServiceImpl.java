package com.oroapp.oro.service;

import com.oroapp.oro.entity.Transaction;
import com.oroapp.oro.entity.User;
import com.oroapp.oro.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepo;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepo.findByUser(user);
    }

    @Override
    public List<Transaction> getTransactionsBetweenDates(User user, LocalDate start, LocalDate end) {
        return transactionRepo.findByUserAndDateBetween(user, start, end);
    }
}
