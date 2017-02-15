package com.twistezo.controllers;

import com.twistezo.models.User;
import com.twistezo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author twistezo
 *
 */

@Controller
public class AddUserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(){
		
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(User user){
		userService.save(user);
		
		return "redirect:/users";
	}
}
