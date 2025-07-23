package com.mx.development.cometa.entity;

import com.mx.development.cometa.converter.ReservationConverter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author josesaidolanogarcia
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String clientFullName;
    private int roomNumber;

    @Convert(converter = ReservationConverter.class)
    private List<LocalDate> reservationDates;
}
