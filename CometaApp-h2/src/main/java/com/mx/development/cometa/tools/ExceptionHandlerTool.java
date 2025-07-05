package com.mx.development.cometa.tools;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author josesaidolanogarcia
 */
public class ExceptionHandlerTool {

    public static ResponseEntity<Map<String, String>> getExceptionMessage(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    public static ResponseEntity<Object> getExceptionMessage(NullPointerException exception) {
        String className = exception.getStackTrace()[0].getClassName();
        String methodName = exception.getStackTrace()[0].getMethodName();
        String fileName = exception.getStackTrace()[0].getFileName();
        String line = exception.getStackTrace()[0].getLineNumber() + "";
        String message = new StringBuilder()
                .append("className: ").append(className)
                .append(" methodName: ").append(methodName)
                .append(" fileName: ").append(fileName)
                .append(" line: ").append(line).append(" ").toString();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
