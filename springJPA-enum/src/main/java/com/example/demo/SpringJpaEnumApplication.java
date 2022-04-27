package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Employee;

@SpringBootApplication
public class SpringJpaEnumApplication implements CommandLineRunner {

	@Autowired
	private Employee employee;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaEnumApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
