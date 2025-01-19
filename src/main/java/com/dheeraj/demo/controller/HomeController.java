package com.dheeraj.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String greet(HttpServletRequest req){        // this request is handled after the login, this is after server assigning the session id to client. so we can tap into the object coming from client for session id
        return "Welcome to my Project \n" + req.getSession().getId();
    }

    @RequestMapping("/about")
    public String about(HttpServletRequest req){
        return "<h1>About Page</h1> " + req.getSession().getId();
    }
}
