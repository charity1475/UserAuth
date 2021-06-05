package com.next.mail.signup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormsTemplateEngine {

  @GetMapping("/login")
  public String login(){
    return "login";
  }
  @GetMapping("/home")
  public String home(){
    return "home";
  }

}
