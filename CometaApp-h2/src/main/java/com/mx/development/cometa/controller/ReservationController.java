package com.mx.development.cometa.controller;

import com.mx.development.cometa.entity.Reservation;
import com.mx.development.cometa.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author josesaidolanogarcia
 */
@RestController
@RequestMapping("/api/v1/hotel")
@Slf4j
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        Reservation reservationCreated = reservationService.createReservation(reservation);
        log.info("Reservation created  {}", reservationCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationCreated);
    }

    @GetMapping("/reservations")
    public Iterable<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }


}
