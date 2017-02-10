package com.twistezo.services;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.twistezo.models.User;
import com.twistezo.repositories.UserDAO;

/**
 * 
 * @author twistezo
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByUsername(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		
//		System.out.println("grantedAuthorities: " +grantedAuthorities);
//		System.out.println("user.getUsername(): " +user.getUsername());
//		System.out.println("user.getPassword(): " +user.getPassword());
//		System.out.println("user.getRole(): " +user.getRole());
//		System.out.println("getAuthorities(user): " +getAuthorities(user));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}
	
	private static Set<GrantedAuthority> getAuthorities(User user) {
		  Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	        authorities.add(new SimpleGrantedAuthority(user.getRole()));
	        return authorities;
	}
	
}
