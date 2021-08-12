package com.diatoz.college.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teacherID;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Teacher name")
	@Size(max = 25, message = "Please enter Teacher name in less than or euqual to 25 alphabet.")
	private String teacherName;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Teacher User ID")
	@Size(max = 5, message = "Please enter Teacher User ID in less than or equal to 5 alphabet.")
	private String teacherUserID;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Password")
	@Size(max = 10, message = "Please enter valid Password less than or equal to 10 alphabets.")
	private String teacherPassword;
	
	@Pattern(regexp = "[6789][0-9]{9}", message = "Please enter valid contact number")
	private String teacherContactNo;
	
	@Email(message = "Please enter a valid email")
	private String teacherEmail;
	
	// to be discuss with Saurav
	private Subject subject;
	

	private Role role;
	
	@ManyToMany
	private Student student;

}
