package com.diatoz.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diatoz.college.confiig.JwtTokenUtil;
import com.diatoz.college.confiig.MyUserDetail;
import com.diatoz.college.model.AuthenticationRequest;
import com.diatoz.college.model.JWTToken;
import com.diatoz.college.service.MyUserDetailsService;

@RestController
public class LoginController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/home")
	public String Hello() {
		
		return "Jai Shree Ram";
	}
	
	
	@PostMapping("/userauthenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		}catch (BadCredentialsException e) {
			throw new Exception("Invalid Username or password", e);
		}
		final MyUserDetail myUserDetails = (MyUserDetail) myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(myUserDetails);
		
		return ResponseEntity.ok(new JWTToken(jwt));
		}
}
