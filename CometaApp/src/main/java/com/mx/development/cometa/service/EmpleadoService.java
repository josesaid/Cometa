package com.mx.development.cometa.service;

import com.mx.development.cometa.entity.Empleado;
import com.mx.development.cometa.repository.EmpleadoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author josesaidolanogarcia
 */
@Service
@Slf4j
public class EmpleadoService {

    @Autowired
    private  EmpleadoRepository empleadoRepository;

    public Empleado createEmployee(Empleado empleado){
        empleado.setNombre(empleado.getNombre().toUpperCase());
        empleado.setApellidoPaterno(empleado.getApellidoPaterno().toUpperCase());
        empleado.setApellidoMaterno(empleado.getApellidoMaterno().toUpperCase());
        empleadoRepository.save(empleado);
        log.info("Empleado creado: {}", empleado);
        return empleado;
    }

    public Optional<Empleado> findByEmpleadoId(String id) {
        Long idLong = Long.parseLong(id);
        return empleadoRepository.findById(idLong);
    }

    public Iterable<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }
}
