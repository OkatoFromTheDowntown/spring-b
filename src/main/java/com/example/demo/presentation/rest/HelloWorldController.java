package com.example.demo.presentation.rest;

import com.example.demo.presentation.annotation.ApiVersion;
import com.example.demo.presentation.exception.ApplicationException;
import com.example.demo.presentation.exception.UnauthorizedAccessingException;
import com.example.demo.presentation.exception.dto.GeneralApplicationExceptionObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author okato
 */
@RestController
public class HelloWorldController {

    @ApiVersion("v0")
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @ApiVersion("v1")
    @GetMapping("/hello")
    public String helloMac() {
        return "Hello V1!";
    }

    @ApiVersion("v2")
    @GetMapping("/hello")
    public String helloWindows() {
        return "Hello V2!";
    }

    @GetMapping("/test/err")
    public String exceptions() {
        throw new ApplicationException("Testing for exception handling from Application Controller");
    }

    @GetMapping("/author")
    public String author() {
        throw new UnauthorizedAccessingException("This Role won't be effective ever.");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GeneralApplicationExceptionObject> handleSpecificControllerException(final RuntimeException e) {
        return new ResponseEntity<>(GeneralApplicationExceptionObject.builder()
                .withTitle("Authorization Denied.")
                .withDescription(e.getMessage())
                .withErrType(e.getClass().getSimpleName())
                .withStatus(HttpStatus.UNAUTHORIZED.value())
                .withErrCode("Error Code: 401")
                .build(), HttpStatus.UNAUTHORIZED);
    }
}
