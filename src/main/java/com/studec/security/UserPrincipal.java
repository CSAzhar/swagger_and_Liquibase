package com.studec.security;

import java.util.Collection;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.studec.entity.User;

//=====================5-b (UserDetails)====================

public class UserPrincipal implements UserDetails{

	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public UserPrincipal(User user) {
		this.user = user;
	}

	
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+user.getRole().name()));
	}

	
	public String getPassword() {
		return user.getPassword();
	}

	
	public String getUsername() {
		return user.getMobile();
	}

	
	public  boolean isAccountNonExpired() {
		return true;
	}

	
	public  boolean isAccountNonLocked() {
		return user.isAccountActive();
	}

	
	public  boolean isCredentialsNonExpired() {
		return true;
	}

	
	public boolean isEnabled() {
		return true;
	}
}
