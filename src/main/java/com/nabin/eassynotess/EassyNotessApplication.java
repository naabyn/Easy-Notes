package com.nabin.eassynotess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EassyNotessApplication {

	public static void main(String[] args) {
		SpringApplication.run(EassyNotessApplication.class, args);
	}
}
