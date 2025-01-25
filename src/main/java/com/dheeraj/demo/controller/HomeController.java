package com.dheeraj.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

/*  Example Workflow

    Without CSRF Token:
    1. User logs in, and the server sets a session ID in a cookie (JSESSIONID=xyz123).
    2. The browser sends the session ID with each request, allowing the server to retrieve session data.
    3. An attacker can exploit the session (if the session ID is stolen) or perform actions using CSRF.

    With CSRF Token:
    1. User logs in, and the server sets a session ID and generates a CSRF token (e.g., csrf123).
    2. The CSRF token is embedded in a form as a hidden field or sent via a custom header.
    3. When the form is submitted or the action is executed, the server checks:
        Session ID (to verify the user).
        CSRF token (to ensure the request is legitimate).
    If both validations pass, the server processes the request.     */

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
