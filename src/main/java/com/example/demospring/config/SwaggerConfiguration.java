package com.example.demospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
@CrossOrigin
public class SwaggerConfiguration {
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot  REST APIs",
                "Spring Boot  REST API Documentation",
                "1",
                "Terms of service",
                new Contact("Anar Mammmadov", "", "mammadov_anar@outlook.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        );
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demospring"))
                .paths(PathSelectors.any())
                .build();
    }

}