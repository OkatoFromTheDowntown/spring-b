package com.example.demo.controller;

import com.example.demo.annotation.ApiVersion;
import com.example.demo.annotation.Platform;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author okato
 */
@RestController
public class HelloWorldController {

    @ApiVersion
    @GetMapping("/hello")
    public String helloWorld() {
        return "HelloWorld!";
    }

    @ApiVersion("v1")
    @GetMapping("/hello")
    public String helloMac() {
        return "HelloMac!";
    }

    @ApiVersion("v2")
    @GetMapping("/hello")
    public String helloWindows() {
        return "HelloWindows!";
    }

    @GetMapping("/author")
    public String author() {
        return "Written by Okato";
    }
}
