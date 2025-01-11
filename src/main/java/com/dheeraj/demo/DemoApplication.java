package com.dheeraj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

//		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Dev obj = (Dev) context.getBean("Dev");
		obj.build();
//		System.out.println(obj.getAge());
//		System.out.println(obj.getSalary());
	}

}
