package com.twistezo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.twistezo.models.User;
import com.twistezo.models.UserWrapper;
import com.twistezo.services.UserService;

/**
 * 
 * @author twistezo
 *
 */

@Controller
@SessionAttributes("userWrapper")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserWrapper userWrapper;
	
	@RequestMapping("/users")
	public String home(Model model){
		List<User> listOfUsers = userService.findAll();
		userWrapper.setListOfUsers(listOfUsers);
		
		model.addAttribute("listOfUsers", listOfUsers);
		model.addAttribute("userWrapper", userWrapper);
		
		return "users";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String deleteUser(@ModelAttribute UserWrapper userWrapper, Model model){
		
		userService.deleteCheckedUser(userWrapper);
		
		return "redirect:/users";
	}
}

