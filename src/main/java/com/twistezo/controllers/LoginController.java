package com.twistezo.controllers;

import com.twistezo.services.SecurityService;
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
public class LoginController {

	@Autowired
	private SecurityService sercurityService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){

		return "login";
	}

}
