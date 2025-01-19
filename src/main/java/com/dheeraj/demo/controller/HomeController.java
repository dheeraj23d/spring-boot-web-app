package com.dheeraj.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String greet(HttpServletRequest req){
        return "Welcome to my Project" + req.getSession().getId();
    }

    @RequestMapping("/about")
    public String about(){
        return "<h1>About Page</h1>";
    }
}
