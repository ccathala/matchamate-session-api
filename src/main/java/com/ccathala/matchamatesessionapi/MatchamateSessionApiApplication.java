package com.ccathala.matchamatesessionapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MatchamateSessionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchamateSessionApiApplication.class, args);
	}
}
