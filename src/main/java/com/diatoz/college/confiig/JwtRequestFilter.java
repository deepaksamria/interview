package com.diatoz.college.confiig;

import com.diatoz.college.model.UserSession;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    JwtSecurityDetailsProvider jwtSecurityDetailsProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        final String authenticationToken = httpServletRequest.getHeader(JwtTokenUtil.AUTHORIZATION);

        if (authenticationToken != null && authenticationToken.startsWith(JwtTokenUtil.BEARER_)) {

            String jwtToken = authenticationToken.substring(7);
            String username = jwtTokenUtil.extractUsername(jwtToken);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserSession userSession = jwtSecurityDetailsProvider.loadUserByUsername(username);
                if (userSession != null && jwtTokenUtil.validateToken(jwtToken, userSession)) {
                    Claims claims = jwtTokenUtil.extractAllClaims(jwtToken);
                    if (claims != null) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                new UsernamePasswordAuthenticationToken(
                                        userSession, null, userSession.getAuthorities());
                        usernamePasswordAuthenticationToken.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                        SecurityContextHolder.getContext()
                                .setAuthentication(usernamePasswordAuthenticationToken);
                        ApplicationContext.setCurrentContext(userSession);
                    }
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
