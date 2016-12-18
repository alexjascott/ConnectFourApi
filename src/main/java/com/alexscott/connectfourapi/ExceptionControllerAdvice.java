package com.alexscott.connectfourapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by alex on 17/12/2016.
 * This catches Exceptions and turns them into a POJO FaultResponse object.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FaultResponse> exceptionHandler(Exception ex) {
        FaultResponse response = new FaultResponse();
        response.setDescription(ex.getMessage());
        return new ResponseEntity<FaultResponse>(response, HttpStatus.BAD_REQUEST);
    }
}