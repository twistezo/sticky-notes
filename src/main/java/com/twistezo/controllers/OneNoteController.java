package com.twistezo.controllers;

import com.twistezo.models.Note;
import com.twistezo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OneNoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/oneNote", method = RequestMethod.GET)
    public String findNoteById(Model model, @RequestParam("id") Long id) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "oneNote";
    }

}