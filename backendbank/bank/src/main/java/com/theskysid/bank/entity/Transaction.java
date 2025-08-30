package com.theskysid.bank.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private Date transactionDate;
   private float creditedAmount;
   private float debitedAmount;
   private float balance;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false)  // foreign key
   private User user;
}
