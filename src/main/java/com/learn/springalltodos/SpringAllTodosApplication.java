package com.learn.springalltodos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class SpringAllTodosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAllTodosApplication.class, args);
	}

}
