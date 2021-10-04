package com.football.betting.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FootballBettingApiApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(FootballBettingApiApplication.class, args);
	}
}
