package com.petcemetery.petcemetery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@SpringBootApplication
public class PetcemeteryApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(PetcemeteryApplication.class, args);
	}	
}
