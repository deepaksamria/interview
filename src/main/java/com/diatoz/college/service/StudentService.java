package com.diatoz.college.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.diatoz.college.model.Student;
import com.diatoz.college.model.Subjects;

@Service
public interface StudentService {
	public Student createStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(Long id);
	public Student updateStudent(Student student, Long id);
	public void deleteStudent(Long id);
	public List<Subjects> updateStudentMarks(Student student, Long id);
	public Student getStudentByusername(String username);
	public int getStudentCount();
}
