package com.webflux.demo.dto;

import lombok.Data;

@Data
public class InputFailedValidationResponse {

    private int code;
    private int input;
    private String message;

}
