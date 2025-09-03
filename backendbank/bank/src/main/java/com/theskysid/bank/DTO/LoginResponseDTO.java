package com.theskysid.bank.DTO;

import com.theskysid.bank.entity.enums.UserStatus;
import lombok.Data;

import java.util.Set;

@Data
public class LoginResponseDTO {

   //it is generated after successfull login
   private String token;

   private String username;
   private Set<String> roles; //check user role if he is customer or admin
   private Set<UserStatus>  userStatus; //check if the user is active or inactive

}
