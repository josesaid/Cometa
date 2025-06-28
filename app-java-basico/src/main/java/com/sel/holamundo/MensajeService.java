package com.sel.holamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author josesaidolanogarcia
 */
@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Transactional
    public Mensaje guardarMensaje(Mensaje mensaje) {
        Mensaje saved = mensajeRepository.save(mensaje);
        if (mensaje.getTexto().contains("error")) {
            throw new RuntimeException("Error al guardar mensaje");
        }
        return saved;
    }

    public List<Mensaje> obtenerMensajes() {
        return mensajeRepository.findAll();
    }
}
