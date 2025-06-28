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

/**
 * @author josesaidolanogarcia
 */
@RestController
@RequestMapping("/api/v1/empleados")
@Slf4j
public class EmpleadosController {

    @Autowired
    private EmpleadoService empleadoService;

    /*public EmpleadosController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }*/

    @GetMapping("/getEmpleados1")
    public String getEmpleados1() {
        return "Hola Mundo1";
    }

    @GetMapping("/getEmpleados2")
    public String getEmpleados2() {
        return "Hola Mundo2";
    }

    @PostMapping()
    public ResponseEntity<Mensaje> createEmpleado(@RequestBody Empleado empleado) {
        log.info("Recibiendo: {}", empleado);

        MensajeExitoso mensajeExitoso = new MensajeExitoso();

        log.info("Clonando: {}", empleado);
        Optional<Empleado> empleadoTemp = Util.cloneEmpleado(empleado);
        if (!empleadoTemp.isEmpty()) {
            log.info("Empleado clonado: {}", empleadoTemp);
        }else{
            log.info("No se pudo validar/clonar el empleado");
        }

        //si OK:
        Empleado empleadoResultante = empleadoService.createEmployee(empleadoTemp.get());
        log.info("Retornando: {}", empleadoResultante);

        if(empleadoResultante.getNombre().length()<5){
            log.error("DEBIO HABER FALLADO!");
            MensajeFallido mensaje = new MensajeFallido();
            mensaje.setMensaje("El nombre del empleado debe tener al menos 5 caracteres");
            mensaje.setId("1234567890");
            mensaje.setError("El nombre del empleado debe tener al menos 5 caracteres");
            mensaje.setTipoError("ERROR_VALIDACION");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensaje);
        }
        mensajeExitoso.setMensaje("Todo esta perfecto y el empleado fue creado exitosamente.");
        mensajeExitoso.setId("1");
        mensajeExitoso.setFecha(LocalDate.now());
        mensajeExitoso.setEmpleado(empleadoResultante);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensajeExitoso);
    }

    @GetMapping("/{empleadoId}")
    public Empleado findEmpleadobyId(@PathVariable("empleadoId") String id){
        Empleado empleado = new Empleado();
        if (id.equals("1")) {
            empleado.setNombre("Jose");
            empleado.setApellidoPaterno("Olano");
            empleado.setApellidoMaterno("Garcia");
        }else{
            empleado.setNombre("Pepe");
            empleado.setApellidoPaterno("Perez");
            empleado.setApellidoMaterno("Garcia");
        }
        return empleado;
    }

    @GetMapping()
    //@GetMapping("/javier")
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

}
