package com.studec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studec.entity.User;
import com.studec.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Tag(name = "Users Controller", description = "Endpoints for user operations")
public class UserController {

    private final PasswordEncoder passwordEncoder;

//    private final PasswordEncoder passwordEncoder;
	
	private final UserService userService;

//    UserController(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

//    UserController(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
	
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
    public ResponseEntity<String> getMyMessage(@PathVariable String message){
    	return ResponseEntity.ok("Personal message path variable: "+message);
    }
    
    
    @GetMapping("/all-user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<User>> registerUser(){
    	return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    
    @GetMapping("/all-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> registerUserget(){
    	return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    
    @GetMapping("/all-admin-user")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<User>> registerUsergetboth(){
    	return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    
    @GetMapping("/all-none")
    @PreAuthorize("denyAll()")
    public ResponseEntity<List<User>> registerUsergetNone(){
    	return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    
    
    
    @Operation(
    		description = "Register users",
    		deprecated = false,
    		hidden = false,
    		method = "POST"
    		)
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	System.out.println("user is: "+user);
//    	user.setUserName(": done");
    	return ResponseEntity.status(200).body(userService.createUser(user));
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
    
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
    	System.out.println("Received - "+user);
    	return userService.verify(user);
    	
    }
}


















