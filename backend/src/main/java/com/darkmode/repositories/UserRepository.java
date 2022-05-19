package com.darkmode.repositories;
import org.springframework.stereotype.Repository;

import com.darkmode.models.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  Optional<User> findByUsername(String username);
	  Boolean existsByUsername(String username);
	  Boolean existsByEmail(String email);
	}


