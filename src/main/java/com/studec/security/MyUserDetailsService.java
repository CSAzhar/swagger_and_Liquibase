package com.studec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studec.entity.User;
import com.studec.repository.UserRepository;

//=====================4-b====================
@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByMobile(username);
//		System.out.println("here user fethc - "+user);
		if(user == null) {
			System.out.println("User not found with  - "+username);
			throw new UsernameNotFoundException("user not found");
		}
		
		return new UserPrincipal(user);
	}
	
	//=====================5-a (UserDetails)====================

}
