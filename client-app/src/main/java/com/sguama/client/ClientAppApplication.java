package com.sguama.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}
}
