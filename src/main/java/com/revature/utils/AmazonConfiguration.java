package com.revature.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfiguration {
	
    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(System.getenv("VIBEZ_ACCESS_KEY"), System.getenv("VIBEZ_SECRET_KEY"));
        return AmazonS3ClientBuilder
            .standard()
            .withRegion("us-east-1")
            .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
            .build(); 
    }
	
	

}
