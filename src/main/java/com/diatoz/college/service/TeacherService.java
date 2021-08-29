package com.diatoz.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diatoz.college.model.Teacher;

@Service
public interface TeacherService {

	public Teacher createTeacher(Teacher teacher);
	public List<Teacher> getAllTeacher();
	public Teacher getTeacherById(Long id);
	public Teacher updateTeacher(Teacher teacher, Long id);
	public void deleteTeacher(Long id);
	public int getTeacherCount();
}
