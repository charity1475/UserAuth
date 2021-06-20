package com.next.mail.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidator{
  private static final String regex =  "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
  private static final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

  public static boolean test(String email) {
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}
