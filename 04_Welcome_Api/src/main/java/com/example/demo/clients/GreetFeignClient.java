package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "GREET-API")
public interface GreetFeignClient {
	
	@GetMapping("/greet")
	public String invokeGreetMsg();

}
