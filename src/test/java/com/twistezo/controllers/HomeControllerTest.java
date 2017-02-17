package com.twistezo.controllers;

import com.twistezo.services.NoteService;
import com.twistezo.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired 
	private NoteService noteService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HomeController homeController;
	
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(homeController).isNotNull();
    }
	
	@Test
	public void checkNotes() throws Exception {
		assertThat(userService.findAll()).isNotNull();
	}
	
//	@Test
//	public void checkUsers() throws Exception {
//		assertThat(noteService.findAll()).isNotNull();
//	}

//	@Test
//	public void checkPageStatus() throws Exception {
//	    this.mockMvc.perform(get("/")).andExpect(status().isOk());
//	}
//
}
