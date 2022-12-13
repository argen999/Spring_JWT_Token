package com.peaksoft.manager;

import com.peaksoft.entity.User;
import com.peaksoft.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Collections;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userRepository.getUserByEmail(email);

        if (user == null) {
            throw new EntityNotFoundException(
                    String.format("User via email = %s not found" + email)
            );
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CustomException(
                    ("Invalid password")
            );
        }

        return new UsernamePasswordAuthenticationToken(email, user.getPassword(), Collections.singletonList(user.getRole()));
    }
}
