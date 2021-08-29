package com.diatoz.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diatoz.college.model.Subjects;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
	
		
}