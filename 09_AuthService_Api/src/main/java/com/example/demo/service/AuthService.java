package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class AuthService{
	
	@Autowired
	private UserRepo uRepo;
	@Autowired
	private JwtService jwt;
	@Autowired
	private PasswordEncoder encoder;
	
	public Boolean saveUser(User user) {
		user.setPswd(encoder.encode(user.getPswd()));
		return uRepo.save(user).getId()!=null?true:false;		
	}
	
	public String generateToken(String username) {
		return jwt.generateToken(username);
	}
	
	public void validateToken(String token) {
		jwt.validateToken(token);
	}

	
	
	
	
	

}
