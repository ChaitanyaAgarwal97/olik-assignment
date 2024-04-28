package com.example.olikbookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class OlikBookStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(OlikBookStoreApplication.class, args);
	}
}
