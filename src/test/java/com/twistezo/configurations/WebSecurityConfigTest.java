package com.twistezo.configurations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebSecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Test
    public void contextLoads() throws Exception {
        assertThat(webSecurityConfig).isNotNull();
    }

    @Test
    public void checkStatusOfAntMatchers() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
        this.mockMvc.perform(get("/register")).andExpect(status().isOk());
        this.mockMvc.perform(get("/login")).andExpect(status().isOk());
    }

}