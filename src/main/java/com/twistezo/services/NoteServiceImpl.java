package com.twistezo.services;

import com.twistezo.models.Note;
import com.twistezo.models.NoteWrapper;
import com.twistezo.repositories.NoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public List<Note> findAll() {
		return this.noteDAO.findAll();
	}

    @Override
    public void deleteCheckedNote(NoteWrapper noteWrapper) {
        System.out.println("NoteServiceImpl:");
        for(Note n : noteWrapper.getListOfNotes()){

            if(n.isNoteChecked()){
                this.noteDAO.delete(n.getId());
            }
        }
    }

}