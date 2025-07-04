package com.mx.development.cometa.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MensajeFallido extends Mensaje {
    private String id;
    private LocalDate fecha;
    private String error;
    private String stackTrace;
    private String TipoError;
}
