package com.twistezo.controllers;

import com.twistezo.models.User;
import com.twistezo.services.SecurityService;
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
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(){
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user){
		userService.save(user);

		/*
		AutoLogin doesn't work properly.
		If you register user, then you should be auto logged and redirect to /index.html
		 */
        securityService.autoLogin(user.getUsername(), user.getPassword());
		
		return "redirect:/index";
	}

}
