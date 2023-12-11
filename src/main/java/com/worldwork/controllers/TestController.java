package com.worldwork.controllers;

import com.worldwork.dto.EntityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/api/v1/hello")
public class TestController {

    @GetMapping
    public ResponseEntity<Object> hello() {
        return EntityResponse.generateResponse("Request successfully", HttpStatus.OK, "Hello, World!");
    }

    @PostMapping
    public ResponseEntity<Object> welcome(@RequestBody String message) {
        return EntityResponse.generateResponse("Request successfully", HttpStatus.OK, "Welcome, " + message + "!");
    }
}
