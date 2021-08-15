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

import com.diatoz.college.utility.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Student")
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

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentID(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentContactNo() {
		return studentContactNo;
	}

	public void setStudentContactNo(String studentContactNo) {
		this.studentContactNo = studentContactNo;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
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

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Student(Long studentID,
			@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Student name") @Size(max = 25, message = "Please enter Student name in less than or euqual to 25 alphabet.") String studentName,
			@Pattern(regexp = "[6789][0-9]{9}", message = "Please enter valid contact number") String studentContactNo,
			@Email(message = "Please enter a valid email") String studentEmail,
			@Pattern(regexp = "[0-9A-Z]{5}", message = "Please enter a valid Center Code i.e. exactly 5 alphanumeric characters") String username,
			String password, List<Subjects> subjects, String role) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentContactNo = studentContactNo;
		this.studentEmail = studentEmail;
		this.username = username;
		this.password = password;
		this.subjects = subjects;
		this.role = role;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentContactNo="
				+ studentContactNo + ", studentEmail=" + studentEmail + ", username=" + username + ", password="
				+ password + ", subjects=" + subjects + ", role=" + role + "]";
	}
	
	
		

}
