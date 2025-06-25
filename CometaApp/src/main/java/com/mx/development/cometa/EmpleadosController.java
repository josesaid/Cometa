package com.mx.development.cometa;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author josesaidolanogarcia
 */
@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadosController {

    @GetMapping("/getEmpleados1")
    public String getEmpleados1() {
        return "Hola Mundo1";
    }

    @GetMapping("/getEmpleados2")
    public String getEmpleados2() {
        return "Hola Mundo2";
    }

    @PostMapping()
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        System.out.println("Empleado creado: " + empleado.getNombre() + "");
        empleado.setNombre(empleado.getNombre().toUpperCase());
        empleado.setApellidoPaterno(empleado.getApellidoPaterno().toUpperCase());
        empleado.setApellidoMaterno(empleado.getApellidoMaterno().toUpperCase());
        return empleado;
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
