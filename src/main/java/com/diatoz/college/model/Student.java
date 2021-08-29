package com.diatoz.college.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.security.auth.Subject;
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
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Student name")
	@Size(max = 25, message = "Please enter Student name in less than or euqual to 25 alphabet.")
	private String studentName;
	
	@Pattern(regexp = "[6789][0-9]{9}", message = "Please enter valid contact number")
	private String studentContactNo;
	
	@Email(message = "Please enter a valid email")
	private String studentEmail;
	
	@Pattern(regexp = "[S][0-9A-Z]{5}" , message = "Please enter a valid Center Code i.e. exactly 6 alphanumeric characters and first letter must be 'S'")
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = com.diatoz.college.model.Subjects.class)
	private List<Subjects> subjects = new ArrayList<>();
	
	private String role;

}
