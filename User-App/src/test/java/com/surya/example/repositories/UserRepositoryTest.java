package com.surya.example.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import com.surya.example.entities.User;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
 
	@DataJpaTest
	class UserRepositoryTest {

	    @Autowired
	    private UserRepository userRepository;

	    @Test
	    void saveUserTest() {
	        User user = new User(null, "Surya", "surya@gmail.com");
	        User saved = userRepository.save(user);

	        Assertions.assertNotNull(saved.getId());
	    }
	    
	    
	    
	    
	    
	    
	    @Test
	    void findByNameTest() {
	        User user = new User(null, "Surya", "surya@gmail.com");
	        userRepository.save(user);

	        List<User> found = userRepository.findByName("Surya");

	        assertEquals(1, found.size());
	    }

	    @Test
	    void findByNameIgnoreCaseTest() {
	        User user = new User(null, "Surya", "surya@gmail.com");
	        userRepository.save(user);

	        List<User> found = userRepository.findByNameIgnoreCase("surya");

	        assertEquals(1, found.size());
	    }
	    
	    
	    
	    
	}

	

