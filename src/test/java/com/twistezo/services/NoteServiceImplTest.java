package com.twistezo.services;

import com.twistezo.models.Note;
import com.twistezo.repositories.NoteDAO;
import com.twistezo.repositories.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteServiceImplTest {

    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private UserDAO userDAO;

    private Note noteTest;

    @Before
    public void setUp() throws Exception {
        noteTest = new Note();
        noteTest.setBody("Test Body");
        noteTest.setDone(true);
        noteTest.setTitle("Test Title");
        noteTest.setAuthor(userDAO.getOne(1L));
        noteTest.setNoteChecked(true);
    }

    @Test
    public void testNoteCRUD() throws Exception {
        noteDAO.save(noteTest);
        Long noteTestId = noteTest.getId();
        noteDAO.delete(noteTestId);
    }

}