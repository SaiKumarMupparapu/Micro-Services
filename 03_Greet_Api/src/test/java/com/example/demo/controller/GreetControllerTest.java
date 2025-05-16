package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.service.MsgService;

@WebMvcTest(controllers = GreetController.class)
public class GreetControllerTest {
	
	@MockBean
	private MsgService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGrtMsg() throws Exception {
		
		when(service.getMsg()).thenReturn("Dummy Text");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/gr/greet");
		
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		 
		 MockHttpServletResponse response = mvcResult.getResponse();
		 int actualStatus = response.getStatus();
		 int expectedStatus=200;
		 assertEquals(expectedStatus, actualStatus);
	}

}
