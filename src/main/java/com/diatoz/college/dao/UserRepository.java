package com.diatoz.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diatoz.college.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	public Users findByUserName(String userName);

}
