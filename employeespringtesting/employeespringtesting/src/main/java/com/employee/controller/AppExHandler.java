package com.employee.controller;

import com.employee.dto.ErrorDetails;
import com.employee.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;


@RestControllerAdvice
public class AppExHandler {

    @Value("${PRODUCT_APP_ERROR_500}")
    private String productAppError500;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handle400   (MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getAllErrors().stream().map(ex1->ex1.getDefaultMessage()).collect(Collectors.joining(","));
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDateTime.now()).status(400).
                message(message).
                toContact("admin@thk.com").build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
    //@ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDetails> handleException500(Exception ex) {
//        ErrorDetails errorMessages = ErrorDetails
//                .builder().timestamp(LocalDateTime.now())
//                .status(500).
//                message(productAppError500)
//                .toContact("admin@thk.com")
//                .build();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessages);
//    }

@ExceptionHandler(EmployeeNotFoundException.class)
public ResponseEntity<ErrorDetails> handle404   (EmployeeNotFoundException ex) {
    ErrorDetails errorDetails = ErrorDetails.builder()
            .timestamp(LocalDateTime.now()).status(404).
            message(ex.getMessage()).
            toContact("admin@thk.com").build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
}








}
