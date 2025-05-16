package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MsgService;

@RestController
@RequestMapping("/api/gr")
public class GreetController {
	
	@Autowired
	private MsgService service;
	
	@GetMapping("/greet")
	public String grtMsg() {
		return service.getMsg();
	}

}
