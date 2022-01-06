package com.revature.utils;

import java.io.IOException;
import java.util.Properties;

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
    public AmazonS3 s3() throws IOException {
        String access = System.getenv("VIBEZ_ACCESS_KEY");
        String secret = System.getenv("VIBEZ_SECRET_KEY");
        
        if(access == null || secret == null){
            Properties prop = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            prop.load(loader.getResourceAsStream("prop.properties"));
            access = prop.getProperty("VIBEZ_ACCESS_KEY");
            secret = prop.getProperty("VIBEZ_SECRET_KEY");
        }
       
        AWSCredentials awsCredentials = new BasicAWSCredentials(access, secret);
        return AmazonS3ClientBuilder
            .standard()
            .withRegion("us-east-1")
            .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
            .build(); 
    }
}
