package com.next.mail.service;

import com.next.mail.appuser.AppUser;
import com.next.mail.appuser.AppUserRole;
import com.next.mail.model.RegistrationRequest;
import com.next.mail.signup.token.ConfirmationToken;
import com.next.mail.signup.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class RegistrationService {

  private final AppUserService appUserService;
  private final EmailValidator emailValidator;
  private final ConfirmationTokenService confirmationTokenService;
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

  @Transactional
  public String confirmToken(String token){
    ConfirmationToken confirmationToken = confirmationTokenService
      .getToken(token).orElseThrow(()->
        new IllegalStateException("Token not found"));
    return "here";
  }
}
