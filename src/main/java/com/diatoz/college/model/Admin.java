package com.diatoz.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Admin name")
	@Size(max = 25, message = "Please enter Admin name in less than or euqual to 25 alphabet.")
	private String adminName;
		
	@Pattern(regexp = "[6789][0-9]{9}", message = "Please enter valid contact number")
	private String adminContactNo;
	
	@Email(message = "Please enter a valid email")
	private String adminEmail;
	
	@Pattern(regexp = "[A][0-9A-Z]{5}" , message = "Please enter a valid Center Code i.e. exactly 6 alphanumeric characters and first letter must be 'A'")
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String role;

	
	
}
