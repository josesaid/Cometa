package com.example.server.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author josesaidolanogarcia
 */

@SpringBootApplication
@EnableAdminServer
public class Lesson16ServerAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson16ServerAdminApplication.class, args);
	}

}
