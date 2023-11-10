package com.webflux.demo.exceptionHandler;

import com.webflux.demo.dto.InputFailedValidationResponse;
import com.webflux.demo.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationHandler {

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<InputFailedValidationResponse> handleException(InputValidationException exception) {
        InputFailedValidationResponse response = new InputFailedValidationResponse();
        response.setCode(exception.getCode());
        response.setInput(exception.getInput());
        response.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
