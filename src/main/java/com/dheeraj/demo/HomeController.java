package com.dheeraj.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String greet(){
        return "Welcome to my Project";
    }

    @RequestMapping("/about")
    public String about(){
        return "<h1>About Page</h1>";
    }
}
