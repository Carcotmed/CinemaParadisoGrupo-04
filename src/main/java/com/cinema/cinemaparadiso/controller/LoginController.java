package com.cinema.cinemaparadiso.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cinema.cinemaparadiso.model.User;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String initFormLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "login";
	}
	
	@GetMapping("/login-error")
	public String errorFormLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login-error";
	}

	@GetMapping("/logoutsecure")
	public String logoutSecure(Model model) {

		return "logout";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		SecurityContextHolder.clearContext();
		return "redirect:/";
	}

	@GetMapping("/terms")
	public String termsConditions(Model model) {
		return "terms";
	}

}
