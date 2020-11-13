package com.exceptionhandle;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ApiException {
    private String message;
    private HttpStatus status;
    private Timestamp timestamp;

    public ApiException(String message, HttpStatus httpStatus, Timestamp zonedDateTime) {
        this.message = message;
        this.status = httpStatus;
        this.timestamp = zonedDateTime;
    }
    public ApiException(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
