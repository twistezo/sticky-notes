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
public class DeleteUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(Model model){
		
		return "deleteUser";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(User user, Model model){
		userService.delete(user);
		
		return "redirect:/users";
	}
}
