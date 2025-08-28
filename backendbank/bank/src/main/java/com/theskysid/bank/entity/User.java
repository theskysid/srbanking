package com.theskysid.bank.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String username;
   private String password;
   private String email;
   private String firstName;
   private String lastName;
   private String address;

   @ElementCollection(fetch = FetchType.EAGER)
   private Set<Role> roles;

}