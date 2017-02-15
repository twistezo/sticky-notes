package com.twistezo.services;

import java.util.List;

import com.twistezo.models.User;
import com.twistezo.models.UserWrapper;

/**
 * 
 * @author twistezo
 *
 */

public interface UserService {
	
	void save(User user);
	void delete(User user);
	void deleteCheckedUser(UserWrapper userWrapper);
	List<User> findAll();
	User findByUsername(String username);
	User findById(Long id);
}
