package com.theskysid.bank.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Data
public class Profile {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long profile_id;

   private String firstName;
   private String lastName;
   private Date dateOfBirth;
   private String address;
   @NotNull
   private Long phoneNo;
   @NotNull
   private String email;

   @OneToOne
   @JoinColumn(name = "user_id")
   private User user;

}
