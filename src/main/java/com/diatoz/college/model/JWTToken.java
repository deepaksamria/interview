package com.diatoz.college.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.Entity;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JWTToken implements Serializable {
    private String jwtToken;
}
