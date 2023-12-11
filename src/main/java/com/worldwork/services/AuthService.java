package com.worldwork.services;

import com.worldwork.dto.AuthRequest;
import com.worldwork.dto.AuthResponse;
import com.worldwork.dto.EntityResponse;
import com.worldwork.dto.UserRequest;
import com.worldwork.entities.Company;
import com.worldwork.entities.Role;
import com.worldwork.entities.User;

import java.util.List;
import java.util.Optional;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);

    AuthResponse refreshToken(String tokenRefresh);

    User createUser(UserRequest userRequest, Role role, Company company);

    Optional<User> getUserById(int id);

    Optional<User> getUserByEmail(String email);

    void deleteUser(int id);

    boolean emailExists(String email);

    List<User> getAllUsers();
}
