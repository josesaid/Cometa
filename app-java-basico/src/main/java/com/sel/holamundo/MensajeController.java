package com.sel.holamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author josesaidolanogarcia
 */
@RestController
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/json")
    public Map<String, String> helloWorldJson() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World in JSON");
        return response;
    }

    @PostMapping("/mensajes")
    public ResponseEntity<String> addMensaje(@RequestBody Map<String, String> body) {
        String texto = body.get("texto");
        Mensaje mensaje = new Mensaje(texto);
        mensajeService.guardarMensaje(mensaje);
        return ResponseEntity.status(HttpStatus.CREATED).body("Mensaje guardado");
    }

    @GetMapping("/mensajes")
    public List<Mensaje> getMensajes() {
        return mensajeService.obtenerMensajes();
    }

    @RequestMapping(value = "/**")
    public ResponseEntity<String> handleNotFound() {
        return new ResponseEntity<>("404 Not Found", HttpStatus.NOT_FOUND);
    }
}
