package com.diatoz.college.confiig;

import com.diatoz.college.model.JWTToken;
import com.diatoz.college.model.UserSession;
import com.diatoz.college.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@RequiredArgsConstructor
public class TokenService {

    private final JdbcTemplate jdbcTemplate;

    public JWTToken generateJWTToken(String userName, String password) {
        Users user = null;
        try {
            user = (Users) jdbcTemplate.queryForObject("select * from users where user_name = ?", new Object[]{userName}, new BeanPropertyRowMapper(Users.class));
        } catch (Exception e) {

        }

        JWTToken jwtDto = new JWTToken();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (user == null) {

        }
        if (!encoder.matches(password, user.getPassword())) {

        } else {
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            UserSession userSession = new UserSession(user.getUserName(), user.getPassword(), user.getUserRole(), user.getId(), new ArrayList<>());
            jwtDto.setJwtToken(jwtTokenUtil.generateToken(userSession));
            jwtDto.setUserId(user.getId());
            jwtDto.setRole(user.getUserRole());
        }
        return jwtDto;
    }
}
