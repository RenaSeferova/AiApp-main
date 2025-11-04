package com.example.alpersonlogdemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI Service API")
                        .version("1.0")
                        .description("Service"));
    }

    @Bean
    public GroupedOpenApi aiApi() {
        return GroupedOpenApi.builder()
                .group("ai-api")
                .packagesToScan("com.example.alpersonlogdemo.config;")
                .build();
    }
}
