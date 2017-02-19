package com.twistezo.services;

import com.twistezo.models.Note;
import com.twistezo.models.NoteWrapper;
import com.twistezo.models.User;
import com.twistezo.repositories.NoteDAO;
import com.twistezo.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author twistezo
 */

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDAO noteDAO;

	@Autowired
    private UserDAO userDAO;

    /**
     * Getting username of current logged user from Security Context.
     * Setting field author to current logged user.
     * Saving note in DB.
     * @param note
     */
    @Override
    public void save(Note note) {

        Object currentUserLoggedUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        for(User user : userDAO.findAll()){
            if(currentUserLoggedUsername.equals(user.getUsername())){
                note.setAuthor(user);
                noteDAO.save(note);
            }
        }
    }

    /**
     * Using NoteWrapper which holds external list of all notes.
     * If some note has true in field note.checkedNote -> save note id DB by id.
     * Field checkedNote is using in front-end side.
     * @param noteWrapper
     */
    @Override
    public void deleteCheckedNote(NoteWrapper noteWrapper) {

        for(Note n : noteWrapper.getListOfNotes()){
            if(n.isNoteChecked()){
                this.noteDAO.delete(n.getId());
            }
        }
    }

    /**
     * Using NoteWrapper which holds external list of all notes.
     * Update() instead of save() saving all notes in DB, not only one by id.
     * @param noteWrapper
     */
    @Override
    public void update(NoteWrapper noteWrapper) {

        for(Note n : noteWrapper.getListOfNotes()){
            this.noteDAO.save(n);
        }
    }

    @Override
    public Note findById(Long id) {
        return this.noteDAO.findById(id);
    }

    @Override
    public List<Note> findAllByOrderByDate() {
        return this.noteDAO.findAllByOrderByDateDesc();
    }

    @Override
    public List<Note> findAllByAuthor(User user) {
        return this.noteDAO.findAllByAuthor(user);
    }

}