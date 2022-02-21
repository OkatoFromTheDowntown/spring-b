package com.example.demo.presentation.filter;

import com.example.demo.presentation.exception.UnauthorizedAccessingException;
import com.example.demo.presentation.exception.dto.GeneralApplicationExceptionObject;
import com.example.demo.presentation.type.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, UnauthorizedAccessingException, IOException {
        String role = request.getHeader("Role");

        if (role == null || !Role.ADMINISTER.value.equals(role.toUpperCase())) {
            throw new UnauthorizedAccessingException("Access denied: Authorization Filter.");
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GeneralApplicationExceptionObject> handleUnauthorizedAccessingException(final RuntimeException e) {
        return new ResponseEntity<>(GeneralApplicationExceptionObject.builder()
                .withTitle("Authorization Denied.")
                .withDescription(e.getMessage())
                .withErrType(e.getClass().getSimpleName())
                .withStatus(HttpStatus.UNAUTHORIZED.value())
                .withErrCode("Error Code: 401")
                .build(), HttpStatus.UNAUTHORIZED);
    }
}