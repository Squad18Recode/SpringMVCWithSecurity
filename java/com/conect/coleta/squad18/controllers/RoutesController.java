package com.conect.coleta.squad18.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutesController {
	
	@GetMapping("/")
	public String home(Model model) { 
		return "../static/index.html";
	}
	
	@GetMapping("/login")
	public String login() { 
		return "pages/login";
	}
}
