package com.next.mail.service;

import com.next.mail.model.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
  public String register(RegistrationRequest request) {
    return "Working state";
  }
}
