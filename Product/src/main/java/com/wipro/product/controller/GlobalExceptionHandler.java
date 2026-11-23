package com.wipro.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.product.dto.response.ErrorResponse;
import com.wipro.product.exception.ProductIdNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ProductIdNotFoundException.class)
    public ResponseEntity<ErrorResponse>
        handleProductNotFound(
        ProductIdNotFoundException ex) {

        return new ResponseEntity<>(
                new ErrorResponse(
                        ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
