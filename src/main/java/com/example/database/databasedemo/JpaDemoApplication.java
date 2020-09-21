package com.example.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.database.databasedemo.entity.Person;
import com.example.database.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		logger.info("All users -> {}", repository.findAll());
		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("Inserting 10004 -> {}", repository.insert(new Person(
				"Tara", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}", repository.update(new Person(10003
				, "Pieter", "Utrecht", new Date())));
		repository.deleteById(10002);

		
	}

}
