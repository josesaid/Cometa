package com.example.lesson16.development.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author josesaidolanogarcia
 */
@RestController
@RequestMapping("/api/v1/demo")
public class ClientesController {

    @GetMapping("/clientes")
    public String clientes() {
        return "Clientes";
    }

}
