package com.worldwork.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;

public interface JwtService {

    String extractUsername(String token);

    String generateToken(UserDetails userDetails);

    String generateRefreshToken(HashMap<String, Object> extractClaims, UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
