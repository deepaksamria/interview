package com.diatoz.college.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Subjects")
public class Subjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subId;
	
	@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Subject name")
	@Size(max = 15, message = "Please enter Subject name in less than or equal to 15 alphabet.")
	private String subjectName;
	
	@Range(min = 0, max = 100, message = "Please enter marks between 0-100 only")
	private int marks;
	
	@ManyToOne
	private Student student;

	public int getId() {
		return subId;
	}

	public void setId(int id) {
		this.subId = subId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subjects(int id,
			@Pattern(regexp = "[a-zA-Z][a-zA-Z\\s]+", message = "Please enter a valid Subject name") @Size(max = 15, message = "Please enter Subject name in less than or equal to 15 alphabet.") String subjectName,
			@Range(min = 0, max = 100, message = "Please enter marks between 0-100 only") int marks, Student student) {
		super();
		this.subId = subId;
		this.subjectName = subjectName;
		this.marks = marks;
		this.student = student;
	}

	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Subjects [subId=" + subId + ", subjectName=" + subjectName + ", marks=" + marks + ", student=" + student + "]";
	}
	
	
	

}
