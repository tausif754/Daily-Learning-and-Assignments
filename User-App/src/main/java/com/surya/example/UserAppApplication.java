package com.surya.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.surya.example.entities.User;
import com.surya.example.repositories.UserRepository;


@SpringBootApplication(scanBasePackages = "com.surya.example")
public class UserAppApplication implements ApplicationRunner{

	@Autowired
	private UserRepository userRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserAppApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		User u1=new User(null,"ramakrishna","ramakrishna@gmail.com");
		userRepository.save(u1);

		User u2=new User(null,"rao","rao@gmail.com");
		userRepository.save(u2);

		User u3=new User(null,"Surya","Surya@gmail.com");
		userRepository.save(u3);

		User u4=new User(null,"Ravi","ravi@outlook.com");
		userRepository.save(u4);
	}

}
