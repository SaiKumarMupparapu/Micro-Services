package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DemoRest {
	
	@GetMapping("/reddis")
	@CircuitBreaker(fallbackMethod = "dataFromDB", name = "reddisCircuite")
	public String dataFromReddis() {
		System.out.println("-----Data resevived from Reddis---------");
		int i=10/0;
		return  "-----Data resevived from Reddis---------";
	}
	
	
	public String dataFromDB(Throwable t) {
		System.out.println("-----Data resevived from Database---------");

		return  "-----Data resevived from Database";
	}

}
