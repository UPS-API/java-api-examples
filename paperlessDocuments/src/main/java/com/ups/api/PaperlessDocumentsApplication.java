package com.ups.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ups.api")
public class PaperlessDocumentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperlessDocumentsApplication.class, args);
	}

}
