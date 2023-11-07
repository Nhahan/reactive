package com.webflux.demo.exception;

public class InputValidationException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "allowed range is 10 - 20";
    private static final int code = 100;
}
