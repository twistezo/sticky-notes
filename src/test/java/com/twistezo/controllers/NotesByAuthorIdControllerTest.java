package com.twistezo.controllers;

import com.twistezo.repositories.UserDAO;
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

/**
 * @author twistezo (19.02.2017)
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NotesByAuthorIdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private NotesByAuthorIdController notesByAuthorIdController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(notesByAuthorIdController).isNotNull();
    }

    @Test
    @WithMockUser(roles="USER")
    public void checkPageStatus() throws Exception {
        this.mockMvc.perform(get("/notesByAuthorId").param("author", "1")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles="USER")
    public void checkNotes() throws Exception {
        Assertions.assertThat(noteService.findAllByAuthor(userDAO.getOne(1L))).isNotNull();
    }

}