package com.theskysid.bank.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @NotBlank(message = "Username is required")
   @Size(min = 2, max = 20, message = "Username must be between 2 and 20")
   private String username;

   @NotBlank(message = "Password is required")
   @Pattern(
           regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
           message = "Password must contain at least one uppercase letter, one lowercase letter, and one number"
   )
   private String password;

   @NotNull(message = "Email is required")
   @Email
   private String email;

   @ElementCollection(fetch = FetchType.EAGER)
   private Set<Role> roles;

//   @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
   @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   private Profile profile;

   @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   private List<Transaction> transactions = new ArrayList<>();

}