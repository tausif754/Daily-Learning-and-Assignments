package com.surya.example.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surya.example.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	List<User> findByName(String name);

	List<User> findByNameIgnoreCase(String name);

	


	

}
