package com.ENOTE_APP;

import com.ENOTE_APP.dto.CategoryResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnoteAppApplication {

	public static void main(String[] args) {
		System.out.println("spring boot started");
		CategoryResponse categoryResponse=new CategoryResponse();
		System.out.println(categoryResponse);
		SpringApplication.run(EnoteAppApplication.class, args);
	}

}
