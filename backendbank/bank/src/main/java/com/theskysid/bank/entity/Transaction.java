package com.theskysid.bank.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private LocalDate transactionDate;
   private Long transactionID;
   private float creditedAmount;
   private float debitedAmount;
   private float balance;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false)  // foreign key
   private User user;

   @ManyToOne
   @JoinColumn(name = "account_id")
   private Account account;
}
