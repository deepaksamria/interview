package com.diatoz.college;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.diatoz.college.dao.AdminRepository;
import com.diatoz.college.model.Admin;
import com.diatoz.college.service.AdminServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DiatozCollegeDataManagementAppApplicationTests {

	@Autowired
	private AdminRepository adminRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@Order(1)
	public void createAdminTest() {
		Admin admin = new Admin();
		admin.setAdminContactNo("9412345678");
		admin.setAdminEmail("abc@gmail.com");
		admin.setAdminName("ADMIN");
		admin.setPassword("ADMIN");
		admin.setRole("ADMIN");
		admin.setUsername("A84771"); // This should be Unique
		Admin savedAdmin = adminRepository.save(admin);
		long adminId = savedAdmin.getAdminId();
		assertNotNull(adminRepository.findByAdminId(adminId));
	}
	
	@Test
	@Order(2)
	public void testGetAdmin() {
		List<Admin> admin = adminRepository.findAll();
		assertThat(admin).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testGetAdminById() {
		Admin admin = adminRepository.findByAdminId(16L);
		assertEquals("ADMIN", admin.getRole());
	}
	
	@Test
	@Order(4)
	public void testDeleteAdmin() {
		adminRepository.deleteById(16L);
		assertThat(adminRepository.existsById(1L)).isFalse();
	}
	}
