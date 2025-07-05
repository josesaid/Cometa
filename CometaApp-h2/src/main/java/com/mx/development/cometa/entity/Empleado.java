package com.mx.development.cometa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author josesaidolanogarcia
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Nombre es requerido")
    @Size(min = 1, max = 10, message = "El nombre debe tener entre 3 y 10 caracteres")
    @Column(nullable = false)
    private String nombre;

    @Column
    private String apellidoPaterno;

    @Column
    private String apellidoMaterno;

}
