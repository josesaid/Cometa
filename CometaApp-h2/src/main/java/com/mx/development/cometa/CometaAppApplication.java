package com.mx.development.cometa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author josesaidolanogarcia
 */
@SpringBootApplication(scanBasePackages = "com.mx.development.cometa")
@EnableJpaRepositories(basePackages = "com.mx.development.cometa.repository")
public class CometaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CometaAppApplication.class, args);
	}

}
