package com.twistezo.services;

import java.util.List;
import com.twistezo.models.User;

/**
 * 
 * @author twistezo
 *
 */

public interface UserService {
	
	void save(User user);
	void delete(User user);
	List<User> findAll();
	User findByUsername(String username);
	User findById(Long id);
}
