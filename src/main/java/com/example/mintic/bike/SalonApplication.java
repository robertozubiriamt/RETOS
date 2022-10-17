package com.example.mintic.bike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.example.mintic.bike.model"})
@SpringBootApplication
public class SalonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonApplication.class, args);
	}

}
