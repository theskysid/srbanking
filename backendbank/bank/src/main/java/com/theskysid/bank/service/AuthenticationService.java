package com.theskysid.bank.service;

import com.theskysid.bank.DTO.SignUpRequestDTO;
import com.theskysid.bank.entity.User;

public interface AuthenticationService {
   String signUp(SignUpRequestDTO signUpRequestDTO);
}
