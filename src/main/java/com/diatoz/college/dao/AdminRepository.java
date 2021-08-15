package com.diatoz.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diatoz.college.model.Admin;
import com.diatoz.college.model.Student;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Admin findByAdminId(Long adminId);
	public Admin deleteByAdminId(Long adminId);
	
}
