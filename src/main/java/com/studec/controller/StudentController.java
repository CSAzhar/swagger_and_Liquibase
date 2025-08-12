package com.studec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studec.entity.Student;
import com.studec.repository.StudentRepository;

@RestController
@RequestMapping("api/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student savedStudent = studentRepository.save(student);
		return ResponseEntity.status(200).body(savedStudent);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudents = studentRepository.findAll();
		return ResponseEntity.status(200).body(allStudents);
	}
	
	

}
