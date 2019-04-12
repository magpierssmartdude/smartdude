package com.smartdude.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

	
	@GetMapping("/")
	public String welcomeMsg() {
		return "Welcome to smart dude";
	}
}
