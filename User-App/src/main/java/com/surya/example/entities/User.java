package com.surya.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity

@Table(name="user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is mandatory")
    private String name;

	@Email(message="Valid email is required !")
    @NotBlank(message = "Email is mandatory")
    private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
	}

	public User(Long id, String name,
			 String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @NotBlank(message="age is required!")
	@Size(min=12,max=30,message="please enter a age between 12 to 30")
	private int age; 
	
	*/
	
	
	
	
	
	
	
}
