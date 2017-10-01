package com.twistezo.services;

import com.twistezo.models.User;
import com.twistezo.models.UserWrapper;
import com.twistezo.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Encoding password by bCrypt.
     * Setting role for new user by default as 'ROLE_USER'.
     * Check whether username exists in DB.
     * If yes -> save user in DB.
     * @param user
     */
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        if (userDAO.findByUsername(user.getUsername()) == null) {
            userDAO.save(user);
        }
    }

    /**
     * Checking whether username & id exists in DB.
     * If yes -> delete username from DB by id.
     * @param user
     */
    @Override
    public void delete(User user) {
        if ((findByUsername(user.getUsername()) != null) && (findById(user.getId()) != null)) {
            this.userDAO.delete(user.getId());
        }
    }

    /**
     * Use userWrapper which holds all users in one external list.
     * If some user has isUserChecked() == true -> delete user from DB.
     * Field userChecked() is using in fronnt-end side.
     * @param userWrapper
     */
    @Override
    public void deleteCheckedUser(UserWrapper userWrapper) {
        for (User u : userWrapper.getListOfUsers()) {
            if (u.isUserChecked() == true) {
                this.userDAO.delete(u.getId());
            }
        }
    }

    /**
     * Update instead of save(), save all users in DB. Not only one by id.
     * @param userWrapper
     */
    @Override
    public void update(UserWrapper userWrapper) {
        for (User n : userWrapper.getListOfUsers()) {
            this.userDAO.save(n);
        }
    }

    @Override
    public User findByUsername(String username) {
        return this.userDAO.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return this.userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return this.userDAO.findAll();
    }

}
