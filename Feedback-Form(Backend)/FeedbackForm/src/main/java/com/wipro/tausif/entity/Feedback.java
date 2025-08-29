package com.wipro.tausif.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Subject is required")
    @Size(max = 40, message = "Subject must be at most 40 characters")
    private String subject;

    @NotBlank(message = "Comments are required")
    @Size(max = 350, message = "Comments must be at most 350 characters")
    private String comments;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}
