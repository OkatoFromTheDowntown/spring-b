package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "HelloWorld!";
    }

    @GetMapping("/author")
    public String author() {
        return "Written by Okato";
    }
}