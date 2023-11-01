package com.example.busorder.exceptions;

import com.example.busorder.models.entities.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleCityNotFoundExceptions(CityNotFoundException exception) {

        ErrorResponse test = ErrorResponse.builder()
                .message("There is no eny city")
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(test, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleRecordExistsInTable(RecordExistsInTableException ex) {
        ErrorResponse build = ErrorResponse.builder()
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(build, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleInvalidCombinationException(InvalidCombinationException ex) {
        ErrorResponse build = ErrorResponse.builder()
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(build, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleCreateEntityException(CreateEntityException ex){
        ErrorResponse build = ErrorResponse.builder()
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

    return new ResponseEntity<>(build,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse response = ErrorResponse.builder()
                .message(ex.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
