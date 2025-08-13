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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/student")
@Tag(name = "Student API", description = "Student APi")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Operation(
			summary = "Create New Student",
			description = "using post mapping to add"
			)
	@ApiResponses(
				value = {
					@ApiResponse(responseCode = "200", description = "Student created successfull"),
					@ApiResponse(responseCode = "500", description = "Server side Error Occured"),
					@ApiResponse(responseCode = "400", description = "Request is not propper")
				}
			)
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student savedStudent = studentRepository.save(student);
		return ResponseEntity.status(200).body(savedStudent);
	}
	
	@Operation(
			summary = "Get All Students",
			description = "using GET method returns list of students"
			)
	@ApiResponse(responseCode = "200", description = "All Students retreived successfully")
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudents = studentRepository.findAll();
		return ResponseEntity.status(200).body(allStudents);
	}
	
	

}
