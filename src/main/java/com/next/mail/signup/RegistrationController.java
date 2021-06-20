package com.next.mail.signup;

import com.next.mail.model.RegistrationRequest;
import com.next.mail.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor

public class RegistrationController {

  private final RegistrationService registrationService;

  @PostMapping(path = "/signup")
  public String register(@RequestBody RegistrationRequest request ) {
      return registrationService.register(request);
  }
  @GetMapping(path = "/confirm")
  public String confirm(@RequestParam("token") String token){
    return registrationService.confirmToken(token);
  }
}
