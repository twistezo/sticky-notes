package com.twistezo.controllers;

import com.twistezo.models.Note;
import com.twistezo.models.NoteWrapper;
import com.twistezo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 *
 * @author twistezo (15.02.2017)
 *
 */

@Controller
@SessionAttributes("noteWrapper")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteWrapper noteWrapper;

    @RequestMapping("/notes")
    public String notes(Model model){

        List<Note> listOfNotes = noteService.findAllByOrderByDate();
        noteWrapper.setListOfNotes(listOfNotes);

        model.addAttribute("listOfNotes", listOfNotes);
        model.addAttribute("noteWrapper", noteWrapper);

        return "notes";
    }

    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public String updateNote(@ModelAttribute NoteWrapper noteWrapper){

        noteService.update(noteWrapper);
        noteService.deleteCheckedNote(noteWrapper);

        return "redirect:/notes";
    }
}


