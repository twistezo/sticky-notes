package com.twistezo.controllers;

import com.twistezo.models.Note;
import com.twistezo.models.User;
import com.twistezo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author twistezo (18.02.2017)
 */

@Controller
public class NotesByAuthorIdController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/notesByAuthorId", method = RequestMethod.GET)
    public String findNoteById(Model model, @RequestParam("author") User author){
        List<Note> notesByAuthorId = noteService.findAllByAuthor(author);
        model.addAttribute("author", author);
        model.addAttribute("notesByAuthorId", notesByAuthorId);

        return "notesByAuthorId";
    }
}
