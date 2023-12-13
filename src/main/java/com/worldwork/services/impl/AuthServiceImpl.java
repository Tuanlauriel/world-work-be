package com.worldwork.services.impl;

import com.worldwork.dto.AuthRequest;
import com.worldwork.dto.AuthResponse;
import com.worldwork.dto.EntityResponse;
import com.worldwork.dto.UserRequest;
import com.worldwork.entities.Company;
import com.worldwork.entities.Role;
import com.worldwork.entities.User;
import com.worldwork.repositories.UserRepository;
import com.worldwork.services.AuthService;
import com.worldwork.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        var user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        String jwt = jwtService.generateToken(user);
        String jwtRefresh = jwtService.generateRefreshToken(new HashMap<>(), user);
        return AuthResponse.builder()
                .token(jwt)
                .tokenRefresh(jwtRefresh)
                .build();
    }

    @Override
    public AuthResponse refreshToken(String tokenRefresh) {
        String email = jwtService.extractUsername(tokenRefresh);
        User user = userRepository.findByEmail(email).orElseThrow();
        if (jwtService.isTokenValid(tokenRefresh, user)) {
            String jwt = jwtService.generateToken(user);
            return AuthResponse.builder()
                    .token(jwt)
                    .tokenRefresh(tokenRefresh)
                    .build();
        }
        return null;
    }

    @Override
    public User createUser(UserRequest userRequest, Role role, Company company) {
        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(role)
                .company(company)
                .build();
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
