package com.sel.holamundo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author josesaidolanogarcia
 */
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {}