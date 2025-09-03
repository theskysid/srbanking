package com.theskysid.bank.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Long accountNumber;
   private int balance;

   @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Transaction> transactions = new ArrayList<>();


}
