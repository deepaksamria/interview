package com.diatoz.college.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.diatoz.college.utility.Role;
import com.diatoz.college.utility.Subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentID;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Student name")
	@Size(max = 25, message = "Please enter Student name in less than or euqual to 25 alphabet.")
	private String studentName;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Student User ID")
	@Size(max = 5, message = "Please enter Student User ID in less than or equal to 5 alphabet.")
	private String studentUserID;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Password")
	@Size(max = 10, message = "Please enter valid Password less than or equal to 10 alphabets.")
	private String studentPassword;
	
	@Pattern(regexp = "[6789][0-9]{9}", message = "Please enter valid contact number")
	private String studentContactNo;
	
	@Email(message = "Please enter a valid email")
	private String studentEmail;
	
	private Subject subject1;
	private Subject subject2;
	private Subject subject3;
	private Role role;
	
	@ManyToMany
	private Teacher teacher;
	
	
	

}
