package com.twistezo.services;

import com.twistezo.models.User;
import com.twistezo.repositories.NoteDAO;
import com.twistezo.repositories.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author twistezo (19.02.2017)
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceImplTest {

    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private UserDAO userDAO;

    private User userTest;

    @Before
    public void setUp() throws Exception {

        userTest = new User();
        userTest.setFirstName("firstNameTest");
        userTest.setLastName("lastNameTest");
        userTest.setPassword("asd");
        userTest.setRole("ROLE_USER");
        userTest.setUsername("usernameTest");
    }

    @Test
    public void testUserCRUD() throws Exception {

        userDAO.save(userTest);

        Long userTestId = userTest.getId();
        userDAO.delete(userTestId);
    }

}