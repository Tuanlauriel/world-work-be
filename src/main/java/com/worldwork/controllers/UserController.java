package com.worldwork.controllers;

import com.worldwork.dto.EntityResponse;
import com.worldwork.dto.UserRequest;
import com.worldwork.entities.Role;
import com.worldwork.entities.User;
import com.worldwork.services.AuthService;
import com.worldwork.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return EntityResponse.generateResponse("Find all users", HttpStatus.OK, authService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") int id) {
        Optional<User> userOptional = authService.getUserById(id);
        return userOptional.map(user -> EntityResponse.generateResponse("Find user by id", HttpStatus.OK, user)).orElseGet(() -> EntityResponse.generateResponse("Invalid id", HttpStatus.NO_CONTENT, "No content"));
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserRequest userRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return EntityResponse.generateResponse("Create user failed", HttpStatus.BAD_REQUEST, "No content");
        }
        if (authService.emailExists(userRequest.getEmail())) {
            return EntityResponse.generateResponse("Email already exists", HttpStatus.CONFLICT, "No content");
        }
        return EntityResponse.generateResponse("Created user successfully", HttpStatus.CREATED, authService.createUser(userRequest, Role.ADMIN, null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") int id) {
        Optional<User> userOptional = authService.getUserById(id);
        if (userOptional.isPresent()) {
            authService.deleteUser(id);
            return EntityResponse.generateResponse("Deleted user successfully", HttpStatus.NO_CONTENT, "No content");
        }
        return EntityResponse.generateResponse("Delete user failed", HttpStatus.NOT_FOUND, "User not found");
    }
}
