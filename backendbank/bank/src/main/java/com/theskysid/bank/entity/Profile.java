package com.theskysid.bank.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
public class Profile {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long profile_id;

   @OneToOne
   @JoinColumn(nullable = false, unique = true, name = "user_id")
   private User user_id;

   private String firstName;
   private String lastName;
   private Date dateOfBirth;
   private String address;
   @NotNull
   private Long phoneNo;
}
