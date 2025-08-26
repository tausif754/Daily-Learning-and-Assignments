package com.surya.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotNull(message="name is required!")
	private String name;
   
	@NotNull(message="email is required!")
	@Email(message="Enter a Valid email")
	private String email;
	
	/*
	  @NotBlank(message="age is required!")
	@Size(min=12,max=30,message="please enter a age between 12 to 30")
	 private int age; 
	
	*/
	
	
}
