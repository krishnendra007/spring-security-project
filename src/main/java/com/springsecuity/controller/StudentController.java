package com.springsecuity.controller;

import com.springsecuity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Ram", "ram@gmail.com"),
            new Student(2,"Shyam", "shyam@gmail.com")
    ));

    @GetMapping
    public List<Student> getAllStudent(){
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }


    @PostMapping
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

}
