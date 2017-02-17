package com.twistezo.controllers;

import com.twistezo.models.Note;
import com.twistezo.models.User;
import com.twistezo.services.NoteService;
import com.twistezo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 
 * @author twistezo
 *
 */

@Controller
public class HomeController {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
    private	UserService userService;

	@RequestMapping("/")
	public String home(Model model){

		List<Note> allNotes = noteService.findAllByOrderByDate();
		List<User> allUsers = userService.findAll();
		
		model.addAttribute("listOfNotes", allNotes);
		model.addAttribute("listOfUsers", allUsers);

		return "index";
	}
}
