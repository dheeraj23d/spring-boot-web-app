package com.dheeraj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Dev {
    //    @Autowired
//    @Qualifier("desktop")
//    Computer computer;
    int age;
    int salary;
    Computer laptop;

    Dev(int a, int b){
        System.out.println("dev constructor");
        age = a;
        salary = b;
    }

    public void build(){
        laptop.compile();
        System.out.println("Building on great project");
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Computer getLaptop() {
        return laptop;
    }

    public void setLaptop(Computer laptop) {
        this.laptop = laptop;
    }
}
