package com.mx.development.cometa.service;

import com.mx.development.cometa.entity.Reservation;
import com.mx.development.cometa.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author josesaidolanogarcia
 */
@Slf4j
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
