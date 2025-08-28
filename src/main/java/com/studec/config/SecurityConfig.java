package com.studec.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	
//    private final StaticController staticController;
    //====define jwt filter class======================
    @Autowired
    private JwtFilter jwtFilter;
	
    
  //=====================4-a====================
	@Autowired
	private UserDetailsService userDetailsService;

//    SecurityConfig(StaticController staticController) {
//        this.staticController = staticController;
//    }
	
	//=====================2====================
	
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request
						.requestMatchers("/api/v1/register", "/api/v1/login")
						.permitAll()
						.anyRequest()
						.authenticated())
				.httpBasic(Customizer.withDefaults())
//				.formLogin(Customizer.withDefaults())
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) //to add jwt filter before login form
				.build();
		
		
	}
	
	//=====================3====================
	@Bean
	 AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
//		daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());    <- this is for without password encoder
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(10));
//		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}
	
	
	//=====================Password encoder bean====================
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	//========Authentication Manger bean to tell spring security to use jjwt=========
	
	@Bean
	 AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	

}
