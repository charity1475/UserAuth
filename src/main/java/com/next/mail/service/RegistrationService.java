package com.next.mail.service;

import com.next.mail.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

  private EmailValidator emailValidator;
  public String register(RegistrationRequest request) {
    boolean isValidEmail = emailValidator.test(request.getEmail());
    if(isValidEmail){

    }
    return "Working state";
  }
}
