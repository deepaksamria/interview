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

import com.diatoz.college.utility.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContactNo() {
		return adminContactNo;
	}

	public void setAdminContactNo(String adminContactNo) {
		this.adminContactNo = adminContactNo;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Admin(Long adminId,
			@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Admin name") @Size(max = 25, message = "Please enter Admin name in less than or euqual to 25 alphabet.") String adminName,
			@Pattern(regexp = "[6789][0-9]{9}", message = "Please enter valid contact number") String adminContactNo,
			@Email(message = "Please enter a valid email") String adminEmail,
			@Pattern(regexp = "[0-9A-Z]{5}", message = "Please enter a valid Center Code i.e. exactly 5 alphanumeric characters") String username,
			String password, String role) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContactNo = adminContactNo;
		this.adminEmail = adminEmail;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContactNo=" + adminContactNo
				+ ", adminEmail=" + adminEmail + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	
}
