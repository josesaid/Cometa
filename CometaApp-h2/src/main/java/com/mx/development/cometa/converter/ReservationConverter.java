package com.mx.development.cometa.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;


/**
 * Converter class used to map between a List of LocalDate objects and their JSON string representation,
 * allowing the storage of complex data types in a database as a single string column.
 * It implements the AttributeConverter interface provided by JPA, enabling automatic
 * conversion during persistence and retrieval processes.
 *
 * The conversion to and from JSON string format facilitates the management of
 * multi-date attributes, particularly where lists of dates need to be stored
 * in a database column. The implementation relies on Jackson's ObjectMapper
 * for JSON processing.
 *
 * Logging is included to handle and record any exceptions that may occur during
 * the conversion process.
 *
 * @author josesaidolanogarcia
 */
@Slf4j
@Converter(autoApply = true)
public class ReservationConverter  implements AttributeConverter<List<LocalDate>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    ReservationConverter(){
        objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * Converts a list of LocalDate objects into a JSON string representation for database storage.
     *
     * @param reservationDates the list of LocalDate objects to be converted
     * @return a JSON string representation of the list of LocalDate objects, or null if conversion fails
     */
    @Override
    public String convertToDatabaseColumn(List<LocalDate> reservationDates) {
        String reservationDatesJSON = null;
        try{
            reservationDatesJSON = objectMapper.writeValueAsString(reservationDates);
        }catch (Exception e){
            log.error("Error al convertir a JSON", e);
        }
        return reservationDatesJSON;
    }


    /**
     * Converts a JSON string representation into a List of LocalDate objects for entity attribute mapping.
     *
     * @param reservationDatesJSON the JSON string representation of a list of LocalDate objects
     * @return a List of LocalDate objects parsed from the input JSON string, or null if conversion fails
     */
    @Override
    public List<LocalDate> convertToEntityAttribute(String reservationDatesJSON) {
        List<LocalDate> reservedDates = null;
        try{
            reservedDates = objectMapper.readValue(reservationDatesJSON, new TypeReference<>() {});
        }catch (Exception e){
            log.error("Error al convertir a lista de fechas", e);
        }
        return reservedDates;
    }

}
