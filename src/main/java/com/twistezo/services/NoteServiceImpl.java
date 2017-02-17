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
 * 
 * @author twistezo
 *
 */

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDAO noteDAO;

	@Autowired
    private UserDAO userDAO;

	@Override
	public List<Note> findAllByOrderByDate() {
		return this.noteDAO.findAllByOrderByDateDesc();
	}

    @Override
    public void deleteCheckedNote(NoteWrapper noteWrapper) {
        for(Note n : noteWrapper.getListOfNotes()){

            if(n.isNoteChecked()){
                this.noteDAO.delete(n.getId());
            }
        }
    }

    /**
     * Only logged user can add note
     * @param note
     */
    @Override
    public void save(Note note) {

        /*
        Get username of current logged user from Security Context
         */
        Object currentUserLoggedUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        for(User user : userDAO.findAll()){
            if(currentUserLoggedUsername.equals(user.getUsername())){
                note.setAuthor(user);
                noteDAO.save(note);
            }
        }
    }

    /**
     * This method makes update of every row in note DB
     * @param noteWrapper
     * bean hold list of notes
     */
    @Override
    public void update(NoteWrapper noteWrapper) {
        for(Note n : noteWrapper.getListOfNotes()){

            this.noteDAO.save(n);
        }
    }

}