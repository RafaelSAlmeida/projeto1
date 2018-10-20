package com.example.projeto1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projeto1.repository.userRepository;

@Controller
public class UserController {
	
	private userRepository userRep;
	
	public UserController(userRepository userRep) {
		this.userRep = userRep;
	}
	
	@RequestMapping("/user")
	public String getUsers(Model model) {
		model.addAttribute("usersList", this.userRep.findAll());
		return "user";
	}

}
