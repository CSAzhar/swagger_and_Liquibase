package com.studec.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
    info = @Info(
        title = "Practice Studec APIs",
        version = "1.1.0",
        description = "API for Studec Project",
        contact = @Contact(name = "Md Azhar Uddin", email = "azhardarampur@gmail.com"),
        summary = "User can log the summary",
        license = @License(name = "lisence -90.8.9")
    ),
    servers = @Server(url = "http://localhost:8003", description = "localhost Dev Server")
)
public class ApiDocsMetaData {
    // Additional configs can go here
}