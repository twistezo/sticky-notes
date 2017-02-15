package com.twistezo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.twistezo.models.User;
import com.twistezo.models.UserWrapper;
import com.twistezo.repositories.UserDAO;

/**
 * 
 * @author twistezo
 *
 */

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public List<User> findAll() {
		return this.userDAO.findAll();
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		/**
		 * VERIFICATION of addUser & register
		 * 1. Check that userinput: username & password aren't empty
		 * 2. Check that userinput: role isn't empty and diffrent from "ROLE_USER"
		 * 3. Check exist of duplicate userinput: username in database
		 * If below is ok -> save new user to DB
		 */
		if(!user.getUsername().isEmpty() & !user.getPassword().isEmpty()){
			if(user.getRole().isEmpty() || user.getRole() != "ROLE_USER"){
				user.setRole("ROLE_USER");
			}

			if(userDAO.findByUsername(user.getUsername()) == null){
				userDAO.save(user);
			}
		}
	}

	@Override
	public User findByUsername(String username) {
		return this.userDAO.findByUsername(username);
	}

	@Override
	public void delete(User user) {
		
		if( (!user.getUsername().isEmpty()) && (user.getId() != null) ){
			if( findByUsername(user.getUsername()) != null){
				if ( findById(user.getId()) != null){
					this.userDAO.delete(user.getId());	
				}
			}
		}
	}

	@Override
	public void deleteCheckedUser(UserWrapper userWrapper) {
		
		for(User u : userWrapper.getListOfUsers()){
			if(u.isUserChecked() == true){
				this.userDAO.delete(u.getId());
			}
		}
	}

	@Override
	public User findById(Long id) {
		return this.userDAO.findById(id);
	}

}
