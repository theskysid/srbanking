//package com.theskysid.bank.controller;
//
//import com.theskysid.bank.entity.Transaction;
//import com.theskysid.bank.entity.User;
//import com.theskysid.bank.service.TransactionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/transactions")
//public class TransactionController {
//
//   @Autowired
//   private TransactionService transactionService;
//
//   //initiate a transaction
//   @PostMapping("/debit")
//   public ResponseEntity<Transaction> debitTransaction(@RequestBody Transaction transaction,
//                                                        Authentication authentication) {
//      // Get logged-in user
//      User user = (User) authentication.getPrincipal();
//
//      // Pass the user to service
//      Transaction saved = transactionService.debitTransaction(user, transaction);
//      return ResponseEntity.ok(saved);
//   }
//
//   @PostMapping("/credit")
//   public ResponseEntity<Transaction> creditTransaction(@RequestBody Transaction transaction,
//                                                       Authentication authentication) {
//      // Get logged-in user
//      User user = (User) authentication.getPrincipal();
//
//      // Pass the user to service
//      Transaction saved = transactionService.creditTransaction(user, transaction);
//      return ResponseEntity.ok(saved);
//   }
//
//   //get all the transactions of the user
//   @GetMapping
//   public ResponseEntity<List<Transaction>> getTransactions(Authentication authentication) {
//      User user = (User) authentication.getPrincipal();
//
//      List<Transaction> transactions = transactionService.getTransactionsByUser(user);
//      return ResponseEntity.ok(transactions);
//   }
//}
