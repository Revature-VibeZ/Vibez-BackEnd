package com.revature.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.revature.DAO.S3Dao;

@Service
public class S3Service implements S3Dao {
	
	private AmazonS3 s3;
    
    private FileService fs;
    
    @Autowired
	public S3Service(AmazonS3 s3, FileService fs) {
		super();
		this.s3 = s3;
		this.fs = fs;
	}
    
    @Override
    public String upload(MultipartFile file) throws IOException {
        
        InputStream inputStream = fs.getInputStream(file);

        ObjectMetadata objectMetadata = fs.getObjectMetadata();

        String uuid = fs.generateUUID();

        s3.putObject("vibez-images", uuid, inputStream, objectMetadata);
        
        URL imageUrl = s3.getUrl("vibez-images", uuid);

        return imageUrl.toString();
    }

}
