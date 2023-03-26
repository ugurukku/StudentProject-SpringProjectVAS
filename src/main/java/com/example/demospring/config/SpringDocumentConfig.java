package com.example.demospring.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SpringDocumentConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("Filankesov Filakes terefinden dokumentasiya")
                        .version("0.0.1")
                        .description("Bu servis blog sayti ucun yazilmisdir")
                        .contact(
                                new Contact()
                                        .url("www.google.com")
                                        .email("google@google.com")
                                        .name("Filankesov Filankes")
                        )
        );

    }

}
