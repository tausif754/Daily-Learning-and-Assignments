package com.surya.example.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.surya.example.entities.User;
import com.surya.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


	private final UserRepository userRepository;

		
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}


	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}


	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}


	@Override
	public Page<User> findAllUserPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}


	@Override
	public void deleteUserById(Long id) {
		 userRepository.deleteById(id);
	}


	@Override
	public User updateUserById(Long id, User user) {
		
		User existedUser=userRepository.findById(id).
				orElseThrow(()->new RuntimeException("User with that id Not Present!"+id));
	
		                      //name=ram123
		existedUser.setName(user.getName());
		existedUser.setEmail(user.getEmail());
		return userRepository.save(existedUser);
	}


	@Override
	public User patchUpdateUserById(Long id, User user) {
		
		User existedUser=userRepository.findById(id).
				orElseThrow(()->new RuntimeException("User with that id Not Present!"+id));
	
		      if(user.getName()!=null)     
		      {
		    	  existedUser.setName(user.getName());
		      }
		      if(user.getEmail()!=null) 
		      {
		    	  existedUser.setEmail(user.getEmail());
		      }
		
		return userRepository.save(existedUser);
	}


	@Override
	public List<User> getUsersByName(String name) {
		return userRepository.findByNameIgnoreCase(name);
	}
	
	
	
	
	
	
	
}
