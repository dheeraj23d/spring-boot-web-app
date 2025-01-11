package com.dheeraj.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class Laptop implements Computer{
    Laptop(){
        System.out.println("Laptop constructor called");
    }
    public void compile(){
        System.out.println("Compiling on Laptop our project");
    }
}
