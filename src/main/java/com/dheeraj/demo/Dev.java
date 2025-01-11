package com.dheeraj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired
    @Qualifier("desktop")
    Computer computer;

    public void build(){
        computer.compile();
        System.out.println("Building on great project");
    }
}
