package com.next.mail.service;

import com.next.mail.appuser.AppUser;
import com.next.mail.repository.UserRepository;
import com.next.mail.signup.token.ConfirmationToken;
import com.next.mail.signup.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

  private final UserRepository userRepository;
  private static final String message = "User with email %s not found";
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final ConfirmationTokenService confirmationTokenService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(message, email)));
  }

  public String signUpUser(AppUser appUser){

    Optional<AppUser> existing = userRepository.findByEmail(appUser.getEmail());
    if(existing.isPresent()){
      throw new IllegalStateException("An email Already exists");
    }
    String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
    appUser.setPassword(encodedPassword);
    userRepository.save(appUser);

    String token = UUID.randomUUID().toString();
    ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),appUser);
    confirmationTokenService.saveConfirmationToken(confirmationToken);
    return token;
  }
}
