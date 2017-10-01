package com.twistezo.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddNoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddNoteController addNoteController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(addNoteController).isNotNull();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void checkPageStatus() throws Exception {
        this.mockMvc.perform(get("/addNote")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    public void checkPostMethod() throws Exception {

        this.mockMvc.perform(post("/addNote").param("username", "user1").param("password", "asd").with(csrf()))
                .andExpect(status().isOk());
    }

}