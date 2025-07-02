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

import static com.mx.development.cometa.tools.MensajeTools.mensajeExito;
import static com.mx.development.cometa.tools.MensajeTools.mensajeFallido;

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

        if (empleadoTemp.get().getNombre()==null || empleadoTemp.get().getNombre().length()<5) {
            log.error("DEBIO HABER FALLADO!");
            return mensajeFallido("El nombre del empleado debe tener al menos 5 caracteres",
                    "12345678908",
                    "ERROR_VALIDACION",
                    HttpStatus.BAD_REQUEST);
        }

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
        return ResponseEntity.status(HttpStatus.OK).body(iterableEmpleados);
    }


    //@PutMapping("/empleados/{id}")
    //public ResponseEntity<Object> createEmpleado(@PathVariable("id") String id, @RequestBody Empleado empleado) {
    //    return null;
    //}


    /*
    @GetMapping()
    public Empleado usaRequestParam(@RequestParam("departamento") String departamento, @RequestParam(value = "area", required = false) String area){
        System.out.println("Departamento: " + departamento);
        System.out.println("area: " + area);

        return new Empleado();
    }

    @GetMapping("/usaRequestParamConOptional")
    public String usaRequestParamConOptional(@RequestParam Optional<String> id){
        return "ID: " + id.orElse("No se recibió ID");
    }

    @GetMapping("/usaRequestParamConValorDefault")
    public String usaRequestParamConValorDefault(@RequestParam(defaultValue = "123") String id){
        return "id: "+ id;
    }
     */
}
