package com.mx.development.cometa.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MensajeExitoso extends Mensaje {
    private String id;
    private LocalDate fecha;
    private Empleado empleado;
}
