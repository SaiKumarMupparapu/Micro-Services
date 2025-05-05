package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.clients.GreetFeignClient;
@RestController
public class WelcomeController {
	@Autowired
	private Environment ev;
	
	@Autowired
	private GreetFeignClient client;
	
	@GetMapping("/wel")
	public String welMsg() {
		
		String greetApi = client.invokeGreetMsg();
		
		return "Good morning ....("+ev.getProperty("server.port")+")"+greetApi;
	}

}
