package com.microservices.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelServiceApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(HotelServiceApplication.class);
		app.setBanner((environment, sourceClass, out) -> {
			out.println("🔥 Hotel SERVICE APPLICATION 🔥");
		});
		app.run(args);
	}

}
