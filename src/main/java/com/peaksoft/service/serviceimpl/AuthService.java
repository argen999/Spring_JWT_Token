package com.peaksoft.service.serviceimpl;

import com.peaksoft.dto.request.AuthRequest;
import com.peaksoft.dto.response.AuthResponse;
import com.peaksoft.manager.TokenUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenUtilities tokenUtilities;

    public AuthResponse authenticate(AuthRequest authRequest) {
        // authentication manager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password())
        );
        // generate token
        return AuthResponse.builder()
                .token(tokenUtilities.generateToken(authentication.getName()))
                .build();
    }

}
