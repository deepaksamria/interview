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

import com.diatoz.college.utility.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

	
	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherContactNo() {
		return teacherContactNo;
	}

	public void setTeacherContactNo(String teacherContactNo) {
		this.teacherContactNo = teacherContactNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public Teacher(Long teacherID,
			@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Teacher name") @Size(max = 25, message = "Please enter Teacher name in less than or euqual to 25 alphabet.") String teacherName,
			@Pattern(regexp = "[6789][0-9]{9}", message = "Please enter valid contact number") String teacherContactNo,
			@Pattern(regexp = "[0-9A-Z]{5}", message = "Please enter a valid Center Code i.e. exactly 5 alphanumeric characters") String username,
			String password, @Email(message = "Please enter a valid email") String teacherEmail, String role) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherContactNo = teacherContactNo;
		this.username = username;
		this.password = password;
		this.teacherEmail = teacherEmail;
		this.role = role;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherContactNo="
				+ teacherContactNo + ", username=" + username + ", password=" + password + ", teacherEmail="
				+ teacherEmail + ", role=" + role + "]";
	}
	
	
	

}
