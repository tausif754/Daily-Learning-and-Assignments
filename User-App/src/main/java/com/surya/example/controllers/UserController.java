package com.surya.example.controllers;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surya.example.entities.User;
import com.surya.example.services.UserService;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j

public class UserController {

	private final UserService userService;

	
	

	@Hidden
	@PostMapping("/addNewUser")	
	public User addUser(@Valid @RequestBody User user) {
		User ExistedUser=userService.save(user);
		
		
		return  ExistedUser;
	}
	
	
	
	
    
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id)
    {
    	 return userService.getUserById(id);
    }
    
    @GetMapping("/getAllUsers")
    public List<User> getAllUser()
    {
    	 return  userService.findAllUser();
    }
    //     ............./getAllUsersPage?page=0&size=10,sort=name,desc
    @GetMapping("/getAllUsersPage")
    public Page<User> getAllUserPage(Pageable pageable)
    {
    	 return  userService.findAllUserPage(pageable);
    }
    
    @DeleteMapping("/deleteUserById/{id}")
    public String deleteUser(@PathVariable Long id)
    {
    	  userService.deleteUserById(id);
    	  //log.warn("i am delteting so ans so user:-{}");
    	  return "user deleted Sucesfully!";
    }
    
    
    @PutMapping("/updateUserById/{id}")
    public User updateUserById(@PathVariable Long id,@RequestBody  User user)
    {
    	 return userService.updateUserById(id,user);
    }
    
    
    @PatchMapping("/patchUpdateUserById/{id}")
    public User patchUpdateUserById(@PathVariable Long id,@RequestBody  User user)
    {
    	 return userService.patchUpdateUserById(id,user);
    }
    
    // i need a endpoint that searches in databse  that user with name is present or name
    
    //http://localhost:8080/findUsersByName/surya
    
    
    @GetMapping("/getUsersByName/{name}")
    public List<User> getUsersByName(@PathVariable String name )
    {
    	return  userService.getUsersByName(name);
    }
  
    
}
