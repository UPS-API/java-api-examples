package com.ups.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ups.api")
public class QuantumViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuantumViewApplication.class, args);
	}

}
