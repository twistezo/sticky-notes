package com.twistezo.controllers;

import com.twistezo.models.Note;
import com.twistezo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author twistezo (15.02.2017)
 */

@Controller
public class AddNoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/addNote", method = RequestMethod.GET)
    public String addNote(){

        return "/addNote";
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public String addNote(Note note){

        noteService.save(note);
        return "redirect:/addNote";
    }


}
