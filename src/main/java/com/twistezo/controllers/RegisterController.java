package com.twistezo.controllers;

import com.twistezo.models.User;
import com.twistezo.services.SecurityService;
import com.twistezo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 
 * @author twistezo
 * @todo securityService.autoLogin(user.getUsername(), user.getPassword()); doesn't work
 */

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(User user){
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "register";
        }
        else{
            userService.save(user);
            securityService.autoLogin(user.getUsername(), user.getPassword());
            return "redirect:/index";
        }


	}

}
