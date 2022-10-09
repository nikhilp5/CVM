package com.example.CVMApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("")
	public String viewLandingPage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String viewRegisterPage() {
		return "";
	}
}
