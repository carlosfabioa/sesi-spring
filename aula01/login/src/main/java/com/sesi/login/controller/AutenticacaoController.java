package com.sesi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutenticacaoController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
