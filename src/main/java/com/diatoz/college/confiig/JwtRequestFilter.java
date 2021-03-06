package com.diatoz.college.confiig;

//import com.diatoz.college.model.UserSession;
import com.diatoz.college.service.MyUserDetailsService;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    
    static String loggedInUserName = null;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authrizationHeader = request.getHeader(JwtTokenUtil.AUTHORIZATION);

        if (authrizationHeader != null && authrizationHeader.startsWith(JwtTokenUtil.BEARER_)) {

            String jwtToken = authrizationHeader.substring(7);
            String username = jwtTokenUtil.extractUsername(jwtToken);
            loggedInUserName = username;
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            	UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);
                if (userDetails != null && jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    Claims claims = jwtTokenUtil.extractAllClaims(jwtToken);
                    if (claims != null) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                new UsernamePasswordAuthenticationToken(
                                		userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext()
                                .setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
            }
        }
        filterChain.doFilter(request, response);
    }
    
   public static String getLoggedInUser() {
    	return loggedInUserName;
    }
}
