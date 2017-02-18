package com.twistezo.services;

import com.twistezo.models.Note;
import com.twistezo.models.NoteWrapper;
import com.twistezo.models.User;

import java.util.List;

/**
 * 
 * @author twistezo
 *
 */

public interface NoteService {
	
	List<Note> findAllByOrderByDate();
    List<Note> findAllByAuthor(User user);
    Note findById(Long id);
    void deleteCheckedNote(NoteWrapper noteWrapper);
    void save(Note note);
    void update(NoteWrapper noteWrapper);

}
