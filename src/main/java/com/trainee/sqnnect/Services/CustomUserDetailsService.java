package com.trainee.sqnnect.Services;
/**
 * 
 * @author yash
 * @version 1.0
 */
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
	/**Spring Security how to look up the user information, 
	 * a class that implements the UserDetailsService interface*/
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		/**Spring Security will invoke the loadUserByUsername() method to authenticate the user,
		 *  and if successful, a new object of type CustomUserDetails object is created to represent the authenticated user.*/
		// TODO Auto-generated method stub
		User user = Repo.findByEmail(email);
		if (email == null)
		{
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomUserDetails(user);
	}

}
