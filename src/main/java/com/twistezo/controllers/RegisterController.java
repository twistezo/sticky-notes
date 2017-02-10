package com.twistezo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.twistezo.models.User;
import com.twistezo.services.SecurityService;
import com.twistezo.services.UserService;

/**
 * 
 * @author twistezo
 *
 */

@Controller
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SecurityService sercurityService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, Model model){
		userService.save(user);
		
		sercurityService.autologin(user.getUsername(), user.getPassword());
		
		return "redirect:/index";
	}

}
