package com.diatoz.college.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diatoz.college.dao.TeacherRepository;
import com.diatoz.college.dao.UserRepository;
import com.diatoz.college.model.Admin;
import com.diatoz.college.model.Teacher;
import com.diatoz.college.model.Users;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Teacher createTeacher(Teacher teacher) {
		teacher.setRole("TEACHER");
		Teacher savedTeacher = teacherRepository.save(teacher);
		Users user = new Users();
		user.setPassword(savedTeacher.getPassword());
		user.setUserName(savedTeacher.getUsername());
		user.setRole(savedTeacher.getRole());
		userRepository.save(user);
		return savedTeacher;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return teacherRepository.findByTeacherId(id);
	}

	@Override
	public Teacher updateTeacher(Teacher teacher, Long id) {
		Teacher teacherFromDataBase = teacherRepository.findByTeacherId(id);
		if(teacherFromDataBase == null) {
			return null;
		}
		teacher.setTeacherId(id);
		teacher.setRole("TEACHER");
		teacher.setUsername(teacherFromDataBase.getUsername());
		
		Users userFromDatabase = userRepository.findByUserName(teacherFromDataBase.getUsername());
		userFromDatabase.setPassword(teacher.getPassword());
		userRepository.save(userFromDatabase);
		return teacherRepository.save(teacher);	
	}
	
	@Override
	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
		}

	@Override
	public int getTeacherCount() {
		List<Teacher> allTeacher = teacherRepository.findAll();
		return allTeacher.size();
	}
}
