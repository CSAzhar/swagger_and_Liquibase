package com.studec.service;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.studec.entity.User;
import com.studec.repository.UserRepository;
import com.studec.security.JWTService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	//==for jwt=====
	private final AuthenticationManager authManager;
	//==for jwt=====
	private JWTService jwtService;
	
	
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User findUserByMobile(String mobile) {
		return userRepository.findByMobile(mobile);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	//==for jwt=====
	public String verify(User user) {
		Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getMobile(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getMobile());
		}
		return "failed";
	}

}
