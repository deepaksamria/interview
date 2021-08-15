package com.diatoz.college.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTToken implements Serializable {
    private String jwtToken;
    //private Long userId;
    //private String role;

	public JWTToken(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public JWTToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
    
}
