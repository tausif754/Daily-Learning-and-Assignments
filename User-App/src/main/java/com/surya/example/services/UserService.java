package com.surya.example.services;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.surya.example.entities.User;

public interface UserService {

	User save(User user);

	User getUserById(Long id);

	List<User> findAllUser();

	Page<User> findAllUserPage(Pageable pageable);

	void deleteUserById(Long id);

	User updateUserById(Long id, User user);

	User patchUpdateUserById(Long id, User user);

	List<User> getUsersByName(String name);


	
	
}
