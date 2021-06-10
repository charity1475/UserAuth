package com.next.mail.service;

import com.next.mail.appuser.AppUser;
import com.next.mail.appuser.AppUserRole;
import com.next.mail.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

  private final AppUserService appUserService;
  private final EmailValidator emailValidator;
  public String register(RegistrationRequest request) {
    boolean isValidEmail = emailValidator.test(request.getEmail());
    if(!isValidEmail){
        throw new IllegalStateException("Email Not Valid");
    }
    return appUserService.signUpUser( new AppUser(
      request.getFirstName(),
      request.getLastName(),
      request.getEmail(),
      request.getPassword(),
      AppUserRole.USER
    ));
  }
}
