package com.twistezo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @info 
 * bcrypted password in database: $2a$10$zYCGrJGBYRJlAoHLNTTJZ.8Gw5pq0gvZFpXHOUz5axZx6.iUjjiNi --> "asd"
 */

@SpringBootApplication
public class StickyNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StickyNotesApplication.class, args);
	}
}
