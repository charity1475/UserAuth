package com.next.mail.signup;

import com.next.mail.model.RegistrationRequest;
import com.next.mail.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor

public class RegistrationController {

  private RegistrationService registrationService;

  @PostMapping(path = "/signup")
  public String register(@RequestBody RegistrationRequest request ) {
      return registrationService.register(request);
  }
}
