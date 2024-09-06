package com.springsecuity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/goodday")
    public String greet(){
        return "Good day";
    }

    @GetMapping("/goodbye")
    public String goodBye(){
        return "Good bye";
    }
}
