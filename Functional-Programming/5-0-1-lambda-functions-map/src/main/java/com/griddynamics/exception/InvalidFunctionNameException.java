package com.griddynamics.exception;

public class InvalidFunctionNameException extends RuntimeException {
    public InvalidFunctionNameException(String functionName) {
        super("Function " + functionName + " doesn't exist.");
    }
}
