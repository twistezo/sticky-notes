package com.twistezo.repositories;

import com.twistezo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	User findById(Long id);

	User findByUsername(String username);

	List<User> findAll();
}
