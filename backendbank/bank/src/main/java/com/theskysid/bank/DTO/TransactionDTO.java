package com.theskysid.bank.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class TransactionDTO {
   private Date transactionDate;
   private Long transactionID;
   private float creditedAmount;
   private float debitedAmount;
   private float balance;
}
