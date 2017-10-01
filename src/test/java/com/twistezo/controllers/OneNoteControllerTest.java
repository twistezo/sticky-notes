package com.twistezo.controllers;

import com.twistezo.repositories.NoteDAO;
import com.twistezo.services.NoteService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OneNoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoteService noteService;

    @Autowired
    private OneNoteController oneNoteController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(oneNoteController).isNotNull();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void checkOneNote() throws Exception {
        Assertions.assertThat(noteService.findById(1L)).isNotNull();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void checkPageStatus() throws Exception {
        this.mockMvc.perform(get("/oneNote").param("id", "1")).andExpect(status().isOk());
    }

}