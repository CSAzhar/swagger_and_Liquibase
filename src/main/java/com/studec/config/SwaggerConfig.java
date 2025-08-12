package com.studec.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api-dev")
                .pathsToMatch("/api/**")
                .build();
    }
    @Bean
    public GroupedOpenApi publicApi1() {
        return GroupedOpenApi.builder()
                .group("public-api-dev1")
                .pathsToMatch("/api/v2/**")
                .build();
    }
}