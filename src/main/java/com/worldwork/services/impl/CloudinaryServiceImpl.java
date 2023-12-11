package com.worldwork.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.worldwork.services.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    @Value("${cloudinary.folder}")
    private String folder;

    @Override
    public String uploadFile(MultipartFile file, String targetFolder) throws IOException {
        Map params = ObjectUtils.asMap(
                "public_id", UUID.randomUUID().toString(),
                "folder", folder + targetFolder
        );
        return cloudinary.uploader().upload(file.getBytes(), params).get("url").toString();
    }

    @Override
    public void deleteFile(String publicId, String targetFolder) throws IOException {
        cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }
}
