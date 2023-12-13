package com.worldwork.services.impl;

import com.worldwork.dto.EntityResponse;
import com.worldwork.entities.Banner;
import com.worldwork.repositories.BannerRepository;
import com.worldwork.services.BannerService;
import com.worldwork.services.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {
    private final CloudinaryService cloudinaryService;
    private final BannerRepository bannerRepository;

    @Override
    public ResponseEntity<Object> createBanner(MultipartFile image, String link) {
        try {
            String bannerUrl = cloudinaryService.uploadFile(image, "/banner");
            Banner banner = bannerRepository.save(Banner.builder().image(bannerUrl).link(link).build());
            return EntityResponse.generateResponse("Created banner successfully", HttpStatus.CREATED, banner);
        } catch (IOException e) {
            return EntityResponse.generateResponse("Create banner failed", HttpStatus.BAD_REQUEST, "");
        }
    }
}
