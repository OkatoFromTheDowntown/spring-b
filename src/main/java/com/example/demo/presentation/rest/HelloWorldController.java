package com.example.demo.presentation.rest;

import com.example.demo.presentation.annotation.ApiVersion;
import com.example.demo.presentation.exception.ApplicationException;
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

    @GetMapping("/author")
    public String author() {
        return "Written by Okato";
    }

    @GetMapping("/test/err")
    public String exceptions() {
        throw new ApplicationException("Testing for exception handling from Application Controller");
    }
}
