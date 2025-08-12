package com.studec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v2")
public class StaticController {
	
	@GetMapping("hello")
	public String getHelloPage() {
		return "redirect:/hello.html";
	}

}
