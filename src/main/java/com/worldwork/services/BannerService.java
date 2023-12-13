package com.worldwork.services;

import com.worldwork.dto.EntityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface BannerService {

    ResponseEntity<Object> createBanner(MultipartFile banner, String link);
}
