package com.revature.DAOs;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface S3Dao {
    String upload(MultipartFile file) throws IOException;
}
