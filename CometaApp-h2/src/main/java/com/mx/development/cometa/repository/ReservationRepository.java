package com.mx.development.cometa.repository;

import com.mx.development.cometa.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author josesaidolanogarcia
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    Reservation findByReservationId(Integer reservationId);
    findByReservatio...
}
