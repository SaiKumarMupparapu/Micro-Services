package com.example.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<User> optionalUser = repo.findByUsername(username);
		 return optionalUser.map(UserInfo::new).orElseThrow(()->new UsernameNotFoundException(username+" User Not found "));
	}

}
