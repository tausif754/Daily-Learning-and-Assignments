package com.wipro.tausif.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.wipro.tausif.user.entity.User;
import com.wipro.tausif.user.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Page<User> getAllUsers(int page, int size) {
        return repo.findAll(PageRequest.of(page, size, Sort.by("fullName")));
    }
    
    
    
    

    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }
    
    

    public User saveUser(User user) {
        return repo.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return repo.findById(id).map(user -> {
            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setAddress(updatedUser.getAddress());
            return repo.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
