package com.studec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
//		UserDetails user1 = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
//				.username("azhar")
//				.password("azhar")
//				.roles("USER")
//				.build();
//		
		return new UserPrincipal(user);
//		return (UserDetails) new InMemoryUserDetailsManager(user1);   <- when using in memory userdetails
	}
	
	//=====================5-a (UserDetails)====================

}
