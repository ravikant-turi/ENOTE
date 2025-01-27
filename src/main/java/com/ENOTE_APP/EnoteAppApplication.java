package com.ENOTE_APP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnoteAppApplication {

	public static void main(String[] args) {
		System.out.println("spring boot started");
		SpringApplication.run(EnoteAppApplication.class, args);
	}

}
