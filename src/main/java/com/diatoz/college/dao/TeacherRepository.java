package com.diatoz.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diatoz.college.model.Teacher;
import com.diatoz.college.model.Users;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	public Teacher findByTeacherId(Long teacherId);
	public Teacher deleteByTeacherId(Long teacherId);

}
