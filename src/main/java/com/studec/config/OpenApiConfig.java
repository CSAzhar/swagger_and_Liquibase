package com.studec.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
    info = @Info(
        title = "Practice Studec API",
        version = "1.0",
        description = "API for Studec Project"
    ),
    servers = @Server(url = "http://localhost:8003", description = "localhost Dev Server")
)
public class OpenApiConfig {
    // Additional configs can go here
}