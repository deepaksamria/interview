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

import com.diatoz.college.model.Admin;
import com.diatoz.college.model.Student;
import com.diatoz.college.model.Teacher;
import com.diatoz.college.service.AdminService;
import com.diatoz.college.service.StudentService;
import com.diatoz.college.service.TeacherService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) {
		Admin createdadmin = adminService.createAdmin(admin);
		if(createdadmin == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.of(Optional.of(createdadmin));
	}
	
	@GetMapping("/getlist")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		List<Admin> allAdmin = adminService.getAllAdmin();
		if(allAdmin.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allAdmin));
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Admin> getAdminById (@PathVariable("id") Long id)
	{
		Admin admin = adminService.getAdminById(id);
		if(admin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(admin));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Admin> updateAdminByID(@Valid @RequestBody Admin admin, @PathVariable("id") Long id){
		Admin updatedAdmin = adminService.updateAdmin(admin, id);
		if(updatedAdmin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(updatedAdmin));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteAdmin(@PathVariable("id") Long id){
		adminService.deleteAdmin(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
		
}
