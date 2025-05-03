package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	@Autowired
	private Environment ev;
	
	@GetMapping("/greet")
	public String grtMsg() {
		return "Welcome to the Clud ("+ev.getProperty("server.port")+")";
	}

}
