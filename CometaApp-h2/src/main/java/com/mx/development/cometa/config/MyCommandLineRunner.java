package com.mx.development.cometa.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author josesaidolanogarcia
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy un CommandLineRunner thread");
    }

}
