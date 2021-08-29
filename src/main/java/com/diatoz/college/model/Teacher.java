package com.diatoz.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long teacherId;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Teacher name")
	@Size(max = 25, message = "Please enter Teacher name in less than or euqual to 25 alphabet.")
	private String teacherName;
	
		
	@Pattern(regexp = "[6789][0-9]{9}", message = "Please enter valid contact number")
	private String teacherContactNo;
	
	@Pattern(regexp = "[T][0-9A-Z]{5}" , message = "Please enter a valid Center Code i.e. exactly 6 alphanumeric characters and first letter must be 'T'")
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@Email(message = "Please enter a valid email")
	private String teacherEmail;
	
	private String role;

	}
