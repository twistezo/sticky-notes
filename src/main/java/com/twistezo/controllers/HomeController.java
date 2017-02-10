package com.twistezo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twistezo.models.Note;
import com.twistezo.models.User;
import com.twistezo.services.NoteService;
import com.twistezo.services.UserService;

/**
 * 
 * @author twistezo
 *
 */

@Controller
public class HomeController {
	
	@Autowired
	NoteService noteService;
	
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String home(Model model){
		List<Note> allNotes = noteService.findAll();
		List<User> allUsers = userService.findAll();
		
		model.addAttribute("listOfNotes", allNotes);
		model.addAttribute("listOfUsers", allUsers);
		return "index";
	}
}
