package com.student.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.sms.entity.Student;
import com.student.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
//	handler method to handle list students and return model and view
	
	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
		
	}
	
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
//		create student objects to holds student form data
		Student student= new Student();
		model.addAttribute("student", student);
		return "add_student";
				
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		
		return "redirect:/students";
		
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "update_student";
		
	}
	
//	handler method 
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		
//		get student from database by id
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setRollNo(student.getRollNo());
		existingStudent.setAge(student.getAge());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setDob(student.getDob());
		existingStudent.setAddress(student.getAddress());
		
//		save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
	} 
	
	
//	Handler method to handle delete student request
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
	    studentService.deleteStudentById(id);
	    return "redirect:/students";
	}

	
    
}
