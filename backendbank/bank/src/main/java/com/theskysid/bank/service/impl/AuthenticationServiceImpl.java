package com.theskysid.bank.service.impl;

import com.theskysid.bank.DTO.SignUpRequestDTO;
import com.theskysid.bank.entity.Profile;
import com.theskysid.bank.entity.User;
import com.theskysid.bank.entity.enums.UserStatus;
import com.theskysid.bank.repository.UserRepository;
import com.theskysid.bank.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private PasswordEncoder passwordEncoder;


   @Override
   public String signUp(SignUpRequestDTO signUpRequestDTO) {

      if(userRepository.findByUsername(signUpRequestDTO.getUsername()).isPresent()){
         throw new RuntimeException("Username is already in use");
      }

      Set<String> role = new HashSet<>();
      role.add("ROLE_USER");



      User user = new User();
      Profile  profile = new Profile();
      user.setUsername(signUpRequestDTO.getUsername());
      user.setPassword(passwordEncoder.encode(signUpRequestDTO.getPassword()));
      user.setEmail(signUpRequestDTO.getEmail());
      user.setStatus(UserStatus.isActive);
      profile.setFirstName(signUpRequestDTO.getFirstname());
      profile.setLastName(signUpRequestDTO.getLastname());
      profile.setAddress(signUpRequestDTO.getAddress());
      profile.setPhoneNo(signUpRequestDTO.getPhoneNo());
      profile.setDateOfBirth(signUpRequestDTO.getDateOfBirth());

      userRepository.save(user);

      return "User Registerd Successfully";
   }

}
