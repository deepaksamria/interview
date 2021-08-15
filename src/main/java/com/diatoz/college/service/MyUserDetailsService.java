package com.diatoz.college.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diatoz.college.confiig.MyUserDetail;
import com.diatoz.college.dao.UserRepository;
import com.diatoz.college.model.Users;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Users user = userRepository.findByUserName(userName);
		if(user==null) {
			throw new UsernameNotFoundException(userName);
		}
		
		MyUserDetail myUserDetail = new MyUserDetail(user);
		return myUserDetail;
		
	}

}
