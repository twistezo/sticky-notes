package com.twistezo.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author twistezo (19.02.2017)
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserDAOTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findById() throws Exception {
        Assertions.assertThat(userDAO.findById(1L)).isNotNull();
    }

    @Test
    public void findByUsername() throws Exception {
        Assertions.assertThat(userDAO.findByUsername("user1")).isNotNull();
    }

    @Test
    public void findAll() throws Exception {
        Assertions.assertThat(userDAO.findAll()).isNotNull();

    }

}