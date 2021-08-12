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
    private Long userId;
    private String role;
}
