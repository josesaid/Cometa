package com.mx.development.cometa.controller;

import com.mx.development.cometa.entity.Empleado;
import com.mx.development.cometa.entity.Mensaje;
import com.mx.development.cometa.entity.MensajeExitoso;
import com.mx.development.cometa.entity.MensajeFallido;
import com.mx.development.cometa.service.EmpleadoService;
import com.mx.development.cometa.tools.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

import static com.mx.development.cometa.tools.MensajeTools.*;

/**
 * @author josesaidolanogarcia
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class EmpleadosController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/empleados")
    public ResponseEntity<Mensaje> createEmpleado(@RequestBody Empleado empleado) {

        log.info("Recibiendo: {}", empleado);
        log.info("Clonando: {}", empleado);

        Optional<Empleado> empleadoTemp = Util.cloneEmpleado(empleado);

        if(empleadoTemp.isEmpty()){
            log.info("No se pudo validar/clonar el empleado");
            return mensajeFallido("Error no se pudo clonar el empleado",
                    "1234567890",
                    "ERROR_INTERNO",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("Empleado clonado: {}", empleadoTemp.get());

        /*if (empleadoTemp.get().getNombre()==null || empleadoTemp.get().getNombre().length()<5) {
            log.error("DEBIO HABER FALLADO!");
            return mensajeFallido("El nombre del empleado debe tener al menos 5 caracteres",
                    "12345678908",
                    "ERROR_VALIDACION",
                    HttpStatus.BAD_REQUEST);
        }*/

        Empleado empleadoResultante = empleadoService.createEmployee(empleadoTemp.get());
        log.info("Retornando: {}", empleadoResultante);
        return mensajeExito("Todo esta perfecto y el empleado fue creado exitosamente.",
                "1",
                empleadoResultante);
    }




    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> findEmpleadobyId(@PathVariable String id) {
        log.info("Buscando empleado con id: {}", id);
        Optional<Empleado> posibleEmpleado = empleadoService.findByEmpleadoId(id);
        if (posibleEmpleado.isPresent()) {
            log.info("Empleado encontrado: {}", posibleEmpleado.get());
            return ResponseEntity.ok(posibleEmpleado.get());
        }
        log.warn("No se encontró empleado con id: {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/empleados")
    public ResponseEntity<Iterable<Empleado>> getAllEmpleados() {
        Iterable iterableEmpleados = empleadoService.getAllEmpleados();
        if (!iterableEmpleados.iterator().hasNext()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(iterableEmpleados);
        }
    }


    @DeleteMapping("/empleados/{deleteId}")
    public ResponseEntity<Mensaje> deleteEmpleadobyId(@PathVariable ("deleteId") String empleadoId) {
        log.info("Buscando empleado: {}", empleadoId);
        Optional<Empleado> posibleEmpleado = empleadoService.findByEmpleadoId(empleadoId);
        if (posibleEmpleado.isPresent()) {
            Empleado empleado = posibleEmpleado.get();
            log.info("Empleado: {} ", empleado);
            empleadoService.deleteEmpleado(empleado);
            log.info("Empleado borrado con éxito: {}", empleado);
            return mensajeEjecutadoConExito("Empleado borrado con éxito.", empleadoId,  empleado);
        }
        log.warn("No se encontró empleado id: {}", empleadoId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
