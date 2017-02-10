package com.twistezo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.twistezo.services.SecurityService;

/**
 * 
 * @author twistezo
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	SecurityService sercurityService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		
		return "login";
	}
	
}
