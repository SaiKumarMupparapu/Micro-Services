package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
public class WelcomeTestController {
	
	@Autowired
	private MockMvc mvc;
     
	@Test
	public void welMsg() throws Exception {
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/wel/welcome");
	          MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
	           MockHttpServletResponse response = mvcResult.getResponse();
	           int status = response.getStatus();
	           System.out.println(response.getContentAsString()+" ::: "+status);

	           assertEquals(200, status);
	}

}
