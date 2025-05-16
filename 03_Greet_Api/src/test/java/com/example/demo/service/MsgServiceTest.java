package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MsgServiceTest {
	@Autowired
	private MsgService msgService;
	
	@Test
	public void testGetMsg() throws Exception {
		String msg = msgService.getMsg();
		assertNotNull(msg);
	}

}
