package com.sel.holamundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author josesaidolanogarcia
 */
@SpringBootApplication
@EnableTransactionManagement
public class AppJavaBasicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppJavaBasicoApplication.class, args);
	}

}
