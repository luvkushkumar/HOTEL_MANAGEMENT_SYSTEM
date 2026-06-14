package com.microservices.hotel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelServiceApplication {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(HotelServiceApplication.class);
		app.setBanner((environment, sourceClass, out) -> {
			out.println("🔥 Hotel SERVICE APPLICATION 🔥");
		});
		app.run(args);
	}

	@Bean
	public CommandLineRunner test() {
		return args -> {
			System.out.println("DB URL = " + dbUrl);
		};
	}
}