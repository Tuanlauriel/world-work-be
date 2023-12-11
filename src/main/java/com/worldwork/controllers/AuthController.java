package com.worldwork.controllers;

import com.worldwork.dto.AuthRequest;
import com.worldwork.dto.EntityResponse;
import com.worldwork.entities.User;
import com.worldwork.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody AuthRequest authRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !authService.emailExists(authRequest.getEmail())) {
            return EntityResponse.generateResponse("Authentication", HttpStatus.BAD_REQUEST, "Invalid email or password");
        }
        return EntityResponse.generateResponse("Authentication", HttpStatus.OK, authService.login(authRequest));
    }
}
