package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Value("${name}")
	private String userName;
	
	@GetMapping("/userName")
	public String userName() {
		return this.userName;		
	}

}
