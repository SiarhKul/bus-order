package com.example.busorder.exceptions;

import com.example.busorder.util.CityNotFoundException;
import com.example.busorder.util.CreteRouteException;
import com.example.busorder.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//todo do validation if route is exiting in the DB
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleCityNotFoundExceptions(CityNotFoundException exception) {

        ErrorResponse test = ErrorResponse.builder()
                .message("error text message")
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(test, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleCreateRouteException(CreteRouteException exception) {

        ErrorResponse test = ErrorResponse.builder()
                .message(exception.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(test, HttpStatus.NOT_FOUND);

    }
}
