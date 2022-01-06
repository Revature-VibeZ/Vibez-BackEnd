package com.revature.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.service.contexts.SecurityContext;

@Data
public class SwaggerConfig {
    public static List<SecurityScheme> apiKey() { 
        return Arrays.asList(new ApiKey("JWT", "Authorization", "header")); 
    }

    public static List<SecurityContext> securityContext() { 
        return Arrays.asList(SecurityContext.builder().securityReferences(defaultAuth()).build()); 
    } 
    
    public static List<SecurityReference> defaultAuth() { 
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
        authorizationScopes[0] = authorizationScope; 
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
    }

    public static ApiInfo apiInfo() {
        return new ApiInfo(
          "VibeZ API",
          "https://github.com/Revature-VibeZ/Vibez-BackEnd",
          "1.0",
          "Terms of service",
          new Contact("Albert", "Lee", "albert.lee@revature.net"),
          "MIT Open License",
          "API license URL",
          Collections.emptyList());
    }
}
