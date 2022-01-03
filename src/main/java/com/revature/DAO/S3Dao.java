package com.revature.DAO;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface S3Dao {
    String upload(MultipartFile file) throws IOException;
}
