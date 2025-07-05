package com.mx.development.cometa.handler;

import com.mx.development.cometa.tools.ExceptionHandlerTool;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author josesaidolanogarcia
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException nullPointException) {
        //Tarea: convertir el mensaje a JSON
        return ExceptionHandlerTool.getExceptionMessage(nullPointException);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException
                                                                                 constraintViolationException){
        String message = constraintViolationException.getMessage();
        return ResponseEntity.badRequest().body(message);
    }

}
