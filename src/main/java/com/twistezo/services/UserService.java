package com.twistezo.services;

import com.twistezo.models.User;
import com.twistezo.models.UserWrapper;

import java.util.List;

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
