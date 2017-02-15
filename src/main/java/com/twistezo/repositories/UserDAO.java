package com.twistezo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twistezo.models.User;

/**
 * 
 * @author twistezo
 *
 */

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	User findByUsername(String username);
	User findById(Long id);
	List<User> findAll();
}
