package com.webflux.demo.exception;

public class InputValidationException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "allowed range is 10 - 20";
    private static final int code = 100;
    private final int input;

    public InputValidationException(int input) {
        super(DEFAULT_MESSAGE);
        this.input = input;
    }

    public int getCode() {
        return code;
    }

    public int getInput() {
        return input;
    }
}
