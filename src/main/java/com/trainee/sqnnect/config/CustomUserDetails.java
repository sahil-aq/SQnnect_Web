package com.trainee.sqnnect.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.trainee.sqnnect.Models.User;
/**
 * 
 * @author yash
 * @version 1.0
 */
public class CustomUserDetails implements UserDetails {
	/**implement authentication (login) feature, we need to create a class of sub-type UserDetails 
	 * (defined by Spring Security) to represent an authentication user*/
	
	private User user;
    
    public CustomUserDetails(User user) {
        this.user = user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getFullName()
	{
		return user.getFirstName() + " " + user.getLastName();
	}

}
