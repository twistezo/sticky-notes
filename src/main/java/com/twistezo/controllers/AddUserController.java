package com.twistezo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.twistezo.models.User;
import com.twistezo.services.UserService;

/**
 * 
 * @author twistezo
 *
 */

@Controller
public class AddUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(Model model){
		
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(User user, Model model){
		userService.save(user);
		
		return "redirect:/users";
	}
}
