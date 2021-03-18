package com.miniblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MiniBlogSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniBlogSpringBootApplication.class, args);
	}

}
