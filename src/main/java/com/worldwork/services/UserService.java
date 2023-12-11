package com.worldwork.services;

import com.worldwork.dto.UserRequest;
import com.worldwork.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();
}
