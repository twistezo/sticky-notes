package com.twistezo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twistezo.models.Note;
import com.twistezo.repositories.NoteDAO;

/**
 * 
 * @author twistezo
 *
 */

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDAO noteDAO;
	
	@Override
	public List<Note> findAll() {
		return this.noteDAO.findAll();
	}

}
