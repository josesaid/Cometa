package com.mx.development.cometa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author josesaidolanogarcia
 */
@Data
@Entity
public class Empleado {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
