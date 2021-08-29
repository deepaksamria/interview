package com.diatoz.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diatoz.college.model.Student;
import com.diatoz.college.model.Teacher;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	public Student findByStudentId(Long studentId);
	public Student findByUsername(String username);

}
