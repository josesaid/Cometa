package com.mx.development.cometa.service;

import com.mx.development.cometa.entity.Empleado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmpleadoService {

    public Empleado createEmployee(Empleado empleado){
        empleado.setNombre(empleado.getNombre().toUpperCase());
        empleado.setApellidoPaterno(empleado.getApellidoPaterno().toUpperCase());
        empleado.setApellidoMaterno(empleado.getApellidoMaterno().toUpperCase());
        log.info("Empleado creado: {}", empleado);
        return empleado;
    }

}
