package com.theskysid.bank.entity;

import com.theskysid.bank.entity.enums.Role;
import com.theskysid.bank.entity.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
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
   @Enumerated(EnumType.STRING)
   private Set<Role> roles;

   @Enumerated(EnumType.STRING)
   private UserStatus status; //it will take enum class only one at a time like active or inactive

//   @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
   @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   private Profile profile;

   @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   private List<Transaction> transactions;

}