package com.surya.example.services;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.surya.example.entities.User;
import com.surya.example.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Test
	@DisplayName("i am testing saveUserInUserServiceImpl")
	void saveUserTest() {
		User user = new User(null, "Surya", "surya@gmail.com");
		User savedUser = new User(1L, "Surya", "surya@gmail.com");

		Mockito.when(userRepository.save(user)).thenReturn(savedUser);

		User result = userService.save(user);
		Assertions.assertEquals(1L, result.getId());
		Assertions.assertEquals("Surya", result.getName());
		Assertions.assertEquals("s1urya@gmail.com", result.getEmail());
	}

	
	
	
	
	
	
	@Test
    void getUserByIdTest() {
        User user = new User(1L, "Surya", "surya@gmail.com");
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        Assertions.assertEquals("Surya", result.getName());
    }

    @Test
    void updateUserByIdTest() {
        User existing = new User(1L, "Old", "old@gmail.com");
        User updated = new User(1L, "New", "new@gmail.com");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(existing));
        Mockito.when(userRepository.save(existing)).thenReturn(updated);

        User result = userService.updateUserById(1L, updated);

        Assertions.assertEquals("New", result.getName());
    }

    @Test
    void patchUpdateUserByIdTest() {
        User existing = new User(1L, "Old", "old@gmail.com");
        User partial = new User(null, "Patched", null);
        User patched = new User(1L, "Patched", "old@gmail.com");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(existing));
        Mockito.when(userRepository.save(existing)).thenReturn(patched);

        User result = userService.patchUpdateUserById(1L, partial);

        Assertions.assertEquals("Patched", result.getName());
    }

    @Test
    void getUsersByNameTest() {
        List<User> users = List.of(new User(1L, "Surya", "surya@gmail.com"));
        Mockito.when(userRepository.findByNameIgnoreCase("Surya")).thenReturn(users);

        List<User> result = userService.getUsersByName("Surya");

        Assertions.assertEquals(1, result.size());
    }
	
	
	
}
