package com.worldwork.controllers;

import com.worldwork.dto.EntityResponse;
import com.worldwork.services.CloudinaryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/upload")
@RequiredArgsConstructor
public class CloudinaryController {
    private final CloudinaryService cloudinaryService;

    @PostMapping("/logo")
    public ResponseEntity<Object> uploadLogo(@Valid @NotNull @RequestParam("logo") MultipartFile file) {
        String fileUrl;
        try {
            fileUrl = cloudinaryService.uploadFile(file, "/logo");
        } catch (IOException e) {
            return EntityResponse.generateResponse("Server error", HttpStatus.BAD_REQUEST, "");
        }
        return EntityResponse.generateResponse("File uploaded successfully", HttpStatus.CREATED, fileUrl);
    }

    @PostMapping("/banner")
    public ResponseEntity<Object> uploadBanner(@Valid @NotNull @RequestParam("banner") MultipartFile file) {
        String fileUrl;
        try {
            fileUrl = cloudinaryService.uploadFile(file, "/banner");
        } catch (IOException e) {
            return EntityResponse.generateResponse("Server error", HttpStatus.BAD_REQUEST, "");
        }
        return EntityResponse.generateResponse("File uploaded successfully", HttpStatus.CREATED, fileUrl);
    }

    @PostMapping("/cv")
    public ResponseEntity<Object> uploadCV(@Valid @NotNull @RequestParam("cv") MultipartFile file) {
        String fileUrl;
        try {
            fileUrl = cloudinaryService.uploadFile(file, "/cv");
        } catch (IOException e) {
            return EntityResponse.generateResponse("Server error", HttpStatus.BAD_REQUEST, "");
        }
        return EntityResponse.generateResponse("File uploaded successfully", HttpStatus.CREATED, fileUrl);
    }
}
