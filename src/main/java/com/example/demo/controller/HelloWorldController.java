package com.example.demo.controller;

import com.example.demo.annotation.Platform;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author okato
 */
@RestController
public class HelloWorldController {

    @Platform
    @GetMapping("/hello")
    public String helloWorld() {
        return "HelloWorld!";
    }

//    @Platform(PlatformType.MAC)
//    @GetMapping("/hello")
//    public String helloMac() {
//        return "HelloMac!";
//    }
//
//    @Platform(PlatformType.WINDOWS)
//    @GetMapping("/hello")
//    public String helloWindows() {
//        return "HelloWindows!";
//    }

    @GetMapping("/author")
    public String author() {
        return "Written by Okato";
    }
}
