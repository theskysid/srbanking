package com.theskysid.bank.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class SignUpRequestDTO {

   private String firstname;
   private String lastname;
   private String email;
   private Date dateOfBirth;
   private Long phoneNo;
   private String address;
   private String username;
   private String password;

}
