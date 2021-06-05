package com.next.mail.signup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class FormsTemplateEngine {

  @GetMapping(path="/login",produces="text/html")
  public String getLoginView() {
    return "login";
  }

}
