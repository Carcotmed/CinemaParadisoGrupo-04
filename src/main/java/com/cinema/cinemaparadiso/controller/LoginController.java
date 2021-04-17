package com.cinema.cinemaparadiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cinema.cinemaparadiso.model.User;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String initFormLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "login";
	}



}
