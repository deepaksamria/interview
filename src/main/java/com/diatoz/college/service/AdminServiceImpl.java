package com.diatoz.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diatoz.college.dao.AdminRepository;
import com.diatoz.college.dao.UserRepository;
import com.diatoz.college.model.Admin;
import com.diatoz.college.model.Users;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Admin createAdmin(Admin admin) {
		admin.setRole("ADMIN");
		Admin savedAdmin = adminRepository.save(admin);
		Users user = new Users();
		user.setPassword(savedAdmin.getPassword());
		user.setUserName(savedAdmin.getUsername());
		user.setRole(savedAdmin.getRole());
		userRepository.save(user);
		return savedAdmin;
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(Long id) {
		return adminRepository.findByAdminId(id);
	}

	@Override
	public Admin updateAdmin(Admin admin, Long id) {
		Admin adminFromDataBase = adminRepository.findByAdminId(id);
		if(adminFromDataBase == null) {
			return null;
		}
		admin.setAdminId(id);
		admin.setRole("ADMIN");
		admin.setUsername(adminFromDataBase.getUsername());
		
		Users userFromDatabase = userRepository.findByUserName(adminFromDataBase.getUsername());
		userFromDatabase.setPassword(admin.getPassword());
		userRepository.save(userFromDatabase);
		return adminRepository.save(admin);	
	}
	
	@Override
	public void deleteAdmin(Long id) {
		adminRepository.deleteById(id);		
	}
}
