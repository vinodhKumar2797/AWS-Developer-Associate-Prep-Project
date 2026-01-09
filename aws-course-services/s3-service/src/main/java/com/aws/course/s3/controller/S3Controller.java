package com.aws.course.s3.controller;

import com.aws.course.s3.service.S3Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/buckets")
    public String createBucket(@RequestParam String bucketName) {
        s3Service.createBucket(bucketName);
        return "Bucket created: " + bucketName;
    }

    @GetMapping("/buckets")
    public List<String> listBuckets() {
        return s3Service.listBuckets();
    }

    @PostMapping("/objects")
    public String uploadObject(@RequestParam String bucketName, @RequestParam String key,
            @RequestParam String content) {
        s3Service.putObject(bucketName, key, content);
        return "Object uploaded to bucket " + bucketName + " with key " + key;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam String bucketName, @RequestParam("file") MultipartFile file)
            throws IOException {
        String key = file.getOriginalFilename();
        Path tempFile = Files.createTempFile("s3-upload-", key);
        Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

        try {
            s3Service.putObject(bucketName, key, tempFile);
            return "File uploaded: " + key;
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }
}
