package com.wipro.tausif.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.tausif.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
