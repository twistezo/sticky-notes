package com.twistezo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twistezo.models.User;
import com.twistezo.services.UserService;

/**
 * 
 * @author twistezo
 *
 */

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/users")
	public String home(Model model){
		List<User> listOfUsers = userService.findAll();
		model.addAttribute("listOfUsers", listOfUsers);
		return "users";
	}
}
