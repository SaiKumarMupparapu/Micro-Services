package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.UserDetailsService;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private AuthService authservice;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		if (authservice.saveUser(user)) {
			return new ResponseEntity<>("Registration Success", org.springframework.http.HttpStatus.CREATED);
		}

		return new ResponseEntity<>("Registration Failed", org.springframework.http.HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/token")
	public ResponseDto login(@RequestBody LoginDto login) {
		ResponseDto response = new ResponseDto();
		try {
			Authentication authenticate = manager
					.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
			String token = null;
			if (authenticate.isAuthenticated()) {
				token = authservice.generateToken(login.getUsername());
				response.setToken(token);
				response.setIsLogedin("Yes");
			}

		} catch (Exception e) {
			response.setToken(null);
			response.setIsLogedin("No");
		}
		return response;

	}

	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		authservice.validateToken(token);
		return "Token is valid";
	}

}
