package com.peaksoft.controller;

import com.peaksoft.dto.request.AuthRequest;
import com.peaksoft.dto.response.AuthResponse;
import com.peaksoft.service.serviceimpl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// data transfer object /dto/
// authenticate
// login username password
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // login
    @PostMapping
    @PreAuthorize("permitAll()")
    AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }

}
