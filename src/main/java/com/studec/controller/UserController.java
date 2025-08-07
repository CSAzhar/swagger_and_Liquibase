package com.studec.controller;

import java.lang.annotation.Target;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "users controller", description = "Endpoints for user operations")
public class UserController {
	
    @GetMapping
    @Operation(
        summary = "summary - Get a welcome message",
        description = "description - Returns a simple welcome message from the API from azhar"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Successfully retrieved messages"
    )
    public ResponseEntity<String> createUser(){
        return ResponseEntity.ok("Message received from api/v1 from get mapping");
    }
    
    @GetMapping("/{message}")
    @Operation(
    		summary = "sum - message check",
    		description = "desc- checking message path variabel"
    		)
    public ResponseEntity<String> getMyMessage(@PathVariable("message") String message){
    	return ResponseEntity.ok("Personal message path variable: "+message);
    }
}