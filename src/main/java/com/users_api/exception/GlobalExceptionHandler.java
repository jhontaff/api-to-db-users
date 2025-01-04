package com.users_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler  {


    private Map<String, List<String>> getErrorsMap(String exception, List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put(exception, errors);
        return errorResponse;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Map<String, List<String>>> handleUserException(UserException exception) {
        List<String> errors = List.of(exception.getMessage());
        return ResponseEntity.badRequest().body(getErrorsMap("User Exception: ", errors));
    }

}
