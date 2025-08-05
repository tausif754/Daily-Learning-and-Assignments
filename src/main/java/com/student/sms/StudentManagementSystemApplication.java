package com.student.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.student.sms.entity.Student;
import com.student.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String...args) throws Exception{
						//		RollNo should be String						// Convert String to LocalDate		
//		Student s1= new Student("Tausif","100",25,"tausif@gmail.com",LocalDate.parse("2003-02-01"),"Bihar");
		
//		studentRepository.save(s1);
		
		
		
	}

}
