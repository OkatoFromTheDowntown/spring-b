package com.example.demo.application.filter;

import com.example.demo.type.Role;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author okato
 */
public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String role = request.getHeader("Role");

        if (role == null || !Role.ADMINISTER.value.equals(role.toUpperCase())) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write("{" + "\"timestamp\":" + System.currentTimeMillis() + ","
                    + "\"status\":" + HttpStatus.UNAUTHORIZED.value() + ","
                    + "\"error\":\"" + HttpStatus.UNAUTHORIZED.getReasonPhrase() + "\","
                    + "\"path\":\"" + request.getRequestURI() + "\"}");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}