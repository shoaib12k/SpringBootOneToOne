package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJpaOtoCustAccApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaOtoCustAccApplication.class, args);
		
		System.out.println("One to one started");
	}

}
