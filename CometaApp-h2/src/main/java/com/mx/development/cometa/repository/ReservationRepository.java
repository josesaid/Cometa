package com.mx.development.cometa.repository;

import com.mx.development.cometa.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author josesaidolanogarcia
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    Reservation findById(int id);
}
