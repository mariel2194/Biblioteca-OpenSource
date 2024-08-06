package com.sg.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sg.biblioteca.models.UserLogin;
import com.sg.biblioteca.models.UserPrincipal;
import com.sg.biblioteca.repositories.UserLoginRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired UserLoginRepository userLoginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserLogin user = userLoginRepository.findByUsername(username);	
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new UserPrincipal(user);
		
		
		
	}

}
