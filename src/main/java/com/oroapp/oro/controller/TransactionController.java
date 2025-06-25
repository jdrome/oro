package com.oroapp.oro.controller;

import com.oroapp.oro.entity.Transaction;
import com.oroapp.oro.entity.User;
import com.oroapp.oro.service.TransactionService;
import com.oroapp.oro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    @Autowired
    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    // POST /api/transactions
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction created = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok(created);
    }

    // GET /api/transactions/user/{user}
    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable Long userid) {
        User user = userService.findById(userid);
        List<Transaction> transactions = transactionService.getTransactionsByUser(user);
        return ResponseEntity.ok(transactions);
    }

    // GET /api/transactions/user/{userId}/range?start=YYYY-MM-DD&end=YYYY-MM-DD
    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<Transaction>> getTransactionsBetweenDates(
            @PathVariable Long userId,
            @RequestParam("start") String startDateStr,
            @RequestParam("end") String endDateStr
    ) {
        User user = userService.findById(userId);
        LocalDate start = LocalDate.parse(startDateStr);
        LocalDate end = LocalDate.parse(endDateStr);

        List<Transaction> transactions = transactionService.getTransactionsBetweenDates(user, start, end);
        return ResponseEntity.ok(transactions);
    }
}
