package com.twistezo.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteWrapper {

    private List<Note> listOfNotes = new ArrayList<>();

    public List<Note> getListOfNotes() {
        return listOfNotes;
    }

    public void setListOfNotes(List<Note> listOfNotes) {
        this.listOfNotes = listOfNotes;
    }

}
