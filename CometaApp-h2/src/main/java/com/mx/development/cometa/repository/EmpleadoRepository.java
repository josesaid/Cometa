package com.mx.development.cometa.repository;

import com.mx.development.cometa.entity.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author josesaidolanogarcia
 */
@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
}
