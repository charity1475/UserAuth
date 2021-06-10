package com.next.mail.service;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {
  private static final String regex =  "^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
  Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

  @Override
  public boolean test(String email) {
    Matcher matcher = pattern.matcher(email);
    return true;
  }
}
