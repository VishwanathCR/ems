package com.vishkode.ems.employee.exception;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse extends RuntimeException {

    private String message;
    private int status;

    public ApiErrorResponse(final String message, final int status) {
        this.message = message;
        this.status = status;
    }
}
