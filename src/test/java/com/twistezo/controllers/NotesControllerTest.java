package com.twistezo.controllers;

import com.twistezo.models.NoteWrapper;
import com.twistezo.services.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NotesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteWrapper noteWrapper;

    @Autowired
    private NotesController notesController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(notesController).isNotNull();
    }

    @Test
    public void checkLists() throws Exception {
        assertThat(noteService.findAllByOrderByDate()).isNotNull();
        assertThat(noteWrapper.getListOfNotes()).isNotNull();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void checkPageStatus() throws Exception {
        this.mockMvc.perform(get("/notes")).andExpect(status().isOk());
    }

}