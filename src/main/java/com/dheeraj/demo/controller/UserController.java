package com.dheeraj.demo.controller;

import com.dheeraj.demo.model.Users;
import com.dheeraj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }
    @PostMapping("/login")
    private String login(@RequestBody Users user){
        return userService.verifyUser(user);
    }
}
