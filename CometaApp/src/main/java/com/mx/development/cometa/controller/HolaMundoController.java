package com.mx.development.cometa.controller;

import com.mx.development.cometa.entity.Empleado;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author josesaidolanogarcia
 */
@RestController
@RequestMapping("/hola")
public class HolaMundoController {

    @GetMapping("/ejemplo01")
    @ResponseBody
    public String[] usaRequestParam(@RequestParam("departamento") String departamento, @RequestParam(value = "area", required = false) String area){
        System.out.println("Departamento: " + departamento);
        System.out.println("area: " + area);

        return new String[]{departamento, area};
    }

    @PostMapping("/ejemplo02")
    @ResponseBody
    //curl -X POST -F 'name=abc' -F 'id=123' http://localhost:8080/hola/ejemplo02
    public String usaRequestConMapa(@RequestParam Map<String,String> allParams) {
        return "Parameters are " + allParams.entrySet();
    }

    @GetMapping("/ejemplo03")
    @ResponseBody
    //http://localhost:8080/hola/ejemplo02?id=1,2,3
    //http://localhost:8080/hola/ejemplo03?id=1&id=2&id=3
    public String usaRequestConLista(@RequestParam List<String> id) {
        return "IDs are " + id;
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
