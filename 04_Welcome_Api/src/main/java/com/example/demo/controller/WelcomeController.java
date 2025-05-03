package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.clients.GreetFeignClient;
@RestController
public class WelcomeController {
	
	@Autowired
	private GreetFeignClient client;
	
	@GetMapping("/Wel")
	public String welMsg() {
		String greetApi = client.invokeGreetMsg();
		
		return "Good morning ...."+greetApi;
	}

}
