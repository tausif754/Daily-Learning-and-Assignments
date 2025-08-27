package com.surya.example.services;


import java.lang.ProcessHandle.Info;
import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.surya.example.entities.User;
import com.surya.example.ex.USER_NOT_FOUND_EXCEPTON;
import com.surya.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
//@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

	
	//private Logger log=(Logger) LoggerFactory.getLogger(UserServiceImpl.class);
@Autowired
	private UserRepository userRepository;

		
	@Override
	public User save(User user) {
		//return userRepository.save(user);
		
		 try {
			   
			 
		        User existedUser= userRepository.save(user);
		         log.warn("after saving to db {}",user.getName());
		         log.warn("after saving to db {}",user.getEmail());
		         return existedUser;
		    } catch (Exception e) {
		    	 log.error("Exception occcured {}",e.getMessage());
		    	throw new RuntimeException("User with that id Not Present!"+e.getMessage());
		    }
		
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
				orElseThrow(()->new USER_NOT_FOUND_EXCEPTON("User with that id Not Present!"+id));
	
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
