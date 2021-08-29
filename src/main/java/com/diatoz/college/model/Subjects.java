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


@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
}
