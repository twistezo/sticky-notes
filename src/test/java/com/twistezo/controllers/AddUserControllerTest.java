package com.twistezo.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddUserControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private AddUserController addUserController;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(addUserController).isNotNull();
    }
	
	@Test
	public void checkPageStatus() throws Exception {
	    this.mockMvc.perform(get("/addUser")).andExpect(status().isOk());
	}
	
	@Test
	public void checkPostMethod() throws Exception {
		this.mockMvc.perform(post("/addUser")).andExpect(status().isOk());
		
	}
	
	@Test
	public void checkPostMethodRedirect() throws Exception {
		this.mockMvc.perform(post("/addUser")).andExpect(redirectedUrl("/users"));
	}
	

}
