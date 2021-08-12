package com.diatoz.college.confiig;

import com.diatoz.college.model.UserSession;
import com.diatoz.college.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtSecurityDetailsProvider implements UserDetailsService {

    private static final Logger logger =
            LoggerFactory.getLogger(JwtSecurityDetailsProvider.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserSession loadUserByUsername(String username) throws UsernameNotFoundException {
        // this will be replaced with couchbase repository tenant/user calls
        try {
            logger.info(String.format("Fetching userDetails for username: %s", username));
            Users user =
                    (Users)
                            jdbcTemplate.queryForObject(
                                    "select * from users where user_name = ?",
                                    new Object[]{username},
                                    new BeanPropertyRowMapper(Users.class));
            UserSession userDetails =
                    new UserSession(
                            user.getUserName(), user.getPassword(), user.getUserRole(), user.getId(), new ArrayList<>());
            logger.info(String.format("Fetched userDetails for username: %s successfully", username));
            return userDetails;
        } catch (Exception exception) {
            logger.error(String.format("Exception while getting user for username: %s", username));
        }
        return null;
    }
}
