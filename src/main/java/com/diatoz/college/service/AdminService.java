package com.diatoz.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diatoz.college.model.Admin;

@Service
public interface AdminService {
	
	public Admin createAdmin(Admin admin);
	public List<Admin> getAllAdmin();
	public Admin getAdminById(Long id);
	public Admin updateAdmin(Admin admin, Long id);
	public void deleteAdmin(Long id);
	
}
