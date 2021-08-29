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

import com.diatoz.college.model.Student;
import com.diatoz.college.model.Subjects;
import com.diatoz.college.model.Teacher;
import com.diatoz.college.service.StudentService;
import com.diatoz.college.service.TeacherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/teacher")
@Api("API that handles all Teachers related operations")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	@ApiOperation("API endpoint to create a new Teacher.")
	public ResponseEntity<Teacher> createTeacher(@Valid @RequestBody Teacher teacher) {
		Teacher createdTeacher = teacherService.createTeacher(teacher);
		if(createdTeacher == null) {
			log.info("Error occured in creating new Teacher User");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		log.info("Admin User created having name "+createdTeacher.getTeacherName());
		return ResponseEntity.of(Optional.of(createdTeacher));
	}
	
	@GetMapping("/getlist")
	public ResponseEntity<List<Teacher>> getAllTeachers(){
		List<Teacher> allTeacher = teacherService.getAllTeacher();
		if(allTeacher.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allTeacher));
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Teacher> getTeacherById (@ApiParam("ID of Teacher of which information is required") @PathVariable("id") Long id)
	{
		Teacher teacher = teacherService.getTeacherById(id);
		if(teacher == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(teacher));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Teacher> updateTeacherByID(@Valid @RequestBody Teacher teacher, @PathVariable("id") Long id){
		Teacher updatedTeacher = teacherService.updateTeacher(teacher, id);
		if(updatedTeacher == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		log.info("Teacher profile updated who is having ID "+id);
		return ResponseEntity.of(Optional.of(updatedTeacher));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTeacher(@PathVariable("id") Long id){
		teacherService.deleteTeacher(id);
		log.info("Teacher profile deleted who is having ID "+id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping("/updatestudentmarks/{id}")
	public ResponseEntity<List<Subjects>> updateStudentMarks(@Valid @RequestBody Student student, @PathVariable("id") Long id){
		List<Subjects> updatedStudentSubjects = studentService.updateStudentMarks(student, id);
		if(updatedStudentSubjects.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		log.info("Marks of Student updated who is having id "+id );
		return ResponseEntity.of(Optional.of(updatedStudentSubjects));
		
	}
	
	@GetMapping("/getteachercount")
	public ResponseEntity<?> getTeacherCount(){
		int teacherCount = teacherService.getTeacherCount();
		if(teacherCount == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(teacherCount));
	}
	
	@GetMapping("/getstudentcount")
	public ResponseEntity<?> getStudentCount(){
		int studentCount = studentService.getStudentCount();
		if(studentCount == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(studentCount));
	}
	
}
