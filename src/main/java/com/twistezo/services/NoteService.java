package com.twistezo.services;

import com.twistezo.models.Note;
import com.twistezo.models.NoteWrapper;
import com.twistezo.models.User;

import java.util.List;

public interface NoteService {

    Note findById(Long id);

    List<Note> findAllByOrderByDate();

    List<Note> findAllByAuthor(User user);

    void save(Note note);

    void update(NoteWrapper noteWrapper);

    void deleteCheckedNote(NoteWrapper noteWrapper);
}
