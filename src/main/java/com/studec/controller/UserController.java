package com.studec.controller;

import java.lang.annotation.Target;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studec.entity.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Users Controller", description = "Endpoints for user operations")
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
    
    @Operation(
    		description = "Register users",
    		deprecated = false,
    		hidden = false,
    		method = "POST"
    		)
    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user){
    	System.out.println("user is: "+user);
    	user.setUserName(user.getUserName()+": done");
    	return ResponseEntity.status(200).body(user);
    }
    
    @Operation(
    		description = "Multiple Params",
    		deprecated = false,
    		hidden = false,
    		summary = "summary -used for test purpose"
    		)
    @PostMapping("/pregPram/{city}")
    public String getMessageFromReq(@RequestParam("name") String name,
    												@RequestParam Integer rolls,
    												@PathVariable String city,
    												@RequestBody User user
    												) {
    	return name+": done, "+rolls+" -roll, City-:"+city+"user is: "+user;
    }
    
    @GetMapping("/get-header")
    public String getHeaderTest(@RequestHeader("token") String token) {
    	return token+" ;is received";
    }
}


















