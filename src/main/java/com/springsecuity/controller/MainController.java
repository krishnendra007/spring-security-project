package com.springsecuity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/goodday")
    public String greet(HttpServletRequest request){
        return "Good day "+ request.getSession().getId();
    }

    @GetMapping("/goodbye")
    public String goodBye(){
        return "Good bye";
    }
}
