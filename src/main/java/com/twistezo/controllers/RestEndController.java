package com.twistezo.controllers;

import com.twistezo.models.Note;
import com.twistezo.models.User;
import com.twistezo.services.NoteService;
import com.twistezo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestEndController {
    private NoteService noteService;
    private UserService userService;

    public RestEndController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @RequestMapping(value = "rest/notes/{id}", method = RequestMethod.GET)
    public Note getNoteById(@PathVariable("id") Long id) {
        return noteService.findById(id);
    }

    @RequestMapping(value = "rest/notes", method = RequestMethod.GET)
    public List<Note> getAllNotes() {
        return noteService.findAllByOrderByDate();
    }

    @RequestMapping(value = "rest/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "rest/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
