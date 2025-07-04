package com.mx.development.cometa.tools;

import com.mx.development.cometa.entity.Empleado;
import com.mx.development.cometa.entity.Mensaje;
import com.mx.development.cometa.entity.MensajeExitoso;
import com.mx.development.cometa.entity.MensajeFallido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

/**
 * @author josesaidolanogarcia
 */
public class MensajeTools {

    static public ResponseEntity<Mensaje> mensajeFallido(String mensaje, String id, String tipo, HttpStatus status){
        MensajeFallido mensajeFallido = new MensajeFallido();
        mensajeFallido.setMensaje(mensaje);
        mensajeFallido.setId(id);
        mensajeFallido.setError(mensaje);
        mensajeFallido.setFecha(LocalDate.now());
        mensajeFallido.setTipoError(tipo);
        return ResponseEntity.status(status).body(mensajeFallido);
    }

    static public ResponseEntity<Mensaje> mensajeExito(String mensaje, String id, Empleado empleado){
        MensajeExitoso mensajeExitoso = new MensajeExitoso();
        mensajeExitoso.setMensaje(mensaje);
        mensajeExitoso.setId(id);
        mensajeExitoso.setFecha(LocalDate.now());
        mensajeExitoso.setEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensajeExitoso);
    }

    static public ResponseEntity<Mensaje> mensajeEjecutadoConExito(String mensaje, String id, Empleado empleado){
        MensajeExitoso mensajeExitoso = new MensajeExitoso();
        mensajeExitoso.setMensaje(mensaje);
        mensajeExitoso.setId(id);
        mensajeExitoso.setFecha(LocalDate.now());
        mensajeExitoso.setEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.OK).body(mensajeExitoso);
    }
}
