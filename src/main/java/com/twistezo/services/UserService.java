package com.twistezo.services;

import com.twistezo.models.User;
import com.twistezo.models.UserWrapper;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    User findById(Long id);

    List<User> findAll();

    void save(User user);

    void delete(User user);

    void deleteCheckedUser(UserWrapper userWrapper);

    void update(UserWrapper userWrapper);
}
