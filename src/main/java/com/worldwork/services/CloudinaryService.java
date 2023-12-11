package com.worldwork.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String uploadFile(MultipartFile file, String targetFolder) throws IOException;

    void deleteFile(String id, String targetFolder) throws IOException;
}
