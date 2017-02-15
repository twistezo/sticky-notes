package com.twistezo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.twistezo.models.Note;

/**
 * 
 * @author twistezo
 *
 */

@Repository
public interface NoteDAO extends JpaRepository<Note, Long> {

	@Query("FROM Note as n ORDER BY n.date DESC")
	Page<Note> findAll(Pageable pageable);

}
