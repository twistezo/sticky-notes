package com.twistezo.repositories;

import com.twistezo.models.Note;
import com.twistezo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDAO extends JpaRepository<Note, Long> {

    Note findById(Long id);

    List<Note> findAllByOrderByDateDesc();

    List<Note> findAllByAuthor(User user);
}
