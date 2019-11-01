package com.crudspringboot.crudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class UniversityApp {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApp.class, args);
	}

}
