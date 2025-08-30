package com.theskysid.bank.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Data
public class Profile {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long profile_id;

   private String firstName;
   private String lastName;
   private Date dateOfBirth;
   private String address;
   @NotNull
   private Long phoneNo;

   @OneToOne
   @JoinColumn(name = "user_id")
   private User user;

}
