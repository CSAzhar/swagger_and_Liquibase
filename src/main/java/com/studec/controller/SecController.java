package com.studec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("sec/v1")
public class SecController {
	
	@GetMapping("/open")
	public String openController(HttpServletRequest request) {
		return "Open Controller hitted"+request.getRequestedSessionId()+" - "+ request.getPathInfo()+" - "+request.getSession().getId();
	}
	
	@GetMapping("/user")
	public String userController() {
		return "User Controller hitted";
	}
	
	@GetMapping("/admin")
	public String adminController() {
		return "Admin Controller hitted";
	}
	
	@GetMapping("/admin-user")
	public String userAndAdminController() {
		return "Admin & User Controller hitted";
	}
	
	@GetMapping("")
	public String pingController() {
		return "Pong Controller hitted";
	}

}
