package com.example.demo.application;

import com.example.demo.annotation.ApiVersion;
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
