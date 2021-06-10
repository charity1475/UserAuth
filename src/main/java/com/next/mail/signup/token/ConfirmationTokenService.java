package com.next.mail.signup.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;
    public void saveConfirmationToken(ConfirmationToken token){
      confirmationTokenRepository.save(token);
    }
    public ConfirmationToken getToken(String token) {
      ConfirmationToken confirmationToken = confirmationTokenRepository.findByToken(token).orElseThrow(()->{
        return new IllegalArgumentException("Token Not found");
      });
      return confirmationToken;
    }
}
