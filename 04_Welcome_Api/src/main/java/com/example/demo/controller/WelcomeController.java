package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/wel")
public class WelcomeController {
//	@Autowired
//	private Environment ev;
//	
//	@Autowired
//	private GreetFeignClient client;
	
	@GetMapping("/welcome")
	public String welMsg() {
//		System.err.println("$$$$+=====================================");
		return "Welcome to the Club";
		
//		String greetApi = client.invokeGreetMsg();
		
//		return "Good morning ....("+ev.getProperty("server.port")+")"+greetApi;
	}

}
