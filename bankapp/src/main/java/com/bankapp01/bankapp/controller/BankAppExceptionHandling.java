package com.bankapp01.bankapp.controller;

import com.bankapp01.bankapp.dto.ErrorResponseDto;
import com.bankapp01.bankapp.exceptions.BankAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

@RestControllerAdvice
public class BankAppExceptionHandling {

    @ExceptionHandler(BankAccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBankAccountNotFoundException(BankAccountNotFoundException e) {
        ErrorResponse errorResponse = ErrorResponseDto.builder()
                .timeStamp(String.valueOf(LocalDateTime.now()))
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .errorMessge(ex.getMessage())
                .toContact("em@gmail.com").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }
}
