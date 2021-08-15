package com.diatoz.college.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diatoz.college.confiig.JwtRequestFilter;
import com.diatoz.college.model.Student;
import com.diatoz.college.model.Subjects;
import com.diatoz.college.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		Student createdStudent = studentService.createStudent(student);
		if(createdStudent == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.of(Optional.of(createdStudent));
	}
	
	@GetMapping("/getlist")
	public ResponseEntity<List<Student>> getAllTeachers(){
		List<Student> allStudent = studentService.getAllStudent();
		if(allStudent.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allStudent));
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Student> getStudentById (@PathVariable("id") Long id)
	{
		Student student = studentService.getStudentById(id);
		if(student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(student));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudentByID(@Valid @RequestBody Student student, @PathVariable("id") Long id){
		Student updatedStudent = studentService.updateStudent(student, id);
		if(updatedStudent == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(updatedStudent));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") Long id){
		studentService.deleteStudent(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/marks")
	public ResponseEntity<List<Subjects>> getMarksInAllSubjects(){
		String loggedInUser = JwtRequestFilter.getLoggedInUser();
		List<Subjects> subjectsOfLoggedInStudent = studentService.getStudentByusername(loggedInUser);
		return ResponseEntity.of(Optional.of(subjectsOfLoggedInStudent));
	}
	
}
