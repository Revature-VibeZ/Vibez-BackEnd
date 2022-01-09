package com.revature.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.revature.DAOs.S3Dao;
import com.revature.utils.AmazonConfiguration;

@Service
public class S3Service implements S3Dao {

    private AmazonS3 s3;
    private FileService fs;

    @Autowired
    public S3Service() throws IOException {
        super();
        this.s3 = new AmazonConfiguration().s3();
        this.fs = new FileService();
    }

    @Override
    public String upload(MultipartFile file) throws IOException {
        InputStream inputStream = fs.getInputStream(file);
        ObjectMetadata objectMetadata = fs.getObjectMetadata();
        String uuid = fs.generateUUID();
        s3.putObject("revature-vibez", uuid, inputStream, objectMetadata);
        return uuid;
    }

    public String getSignedUrl(String uuid) {
        // Set the presigned URL to expire after one hour.
        java.util.Date expiration = new java.util.Date();
        long expTimeMillis = Instant.now().toEpochMilli();
        expTimeMillis += 1000 * 60 * 60;
        expiration.setTime(expTimeMillis);

        // Generate the presigned URL.
        System.out.println("Generating pre-signed URL.");
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest("revature-vibez",
                uuid)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(expiration);
        URL url = s3.generatePresignedUrl(generatePresignedUrlRequest);
        System.out.println("Pre-Signed URL: " + url.toString());
        return url.toString();
    }
}
