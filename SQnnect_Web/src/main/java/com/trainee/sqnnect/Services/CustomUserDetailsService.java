package com.trainee.sqnnect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.trainee.sqnnect.Models.User;
import com.trainee.sqnnect.Repository.UserRepository;

import com.trainee.sqnnect.config.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository Repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = Repo.findByEmail(email);
		if (email == null)
		{
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomUserDetails(user);
	}

}
