package com.theskysid.bank.controller;

import com.theskysid.bank.DTO.SignUpRequestDTO;
import com.theskysid.bank.entity.User;
import com.theskysid.bank.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

   @Autowired
   private AuthenticationService authenticationService;

   @PostMapping("/signup")
   public ResponseEntity<String> signUpUser(@RequestBody SignUpRequestDTO signUpRequestDTO) {
      return ResponseEntity.ok(authenticationService.signUp(signUpRequestDTO));
   }



}
