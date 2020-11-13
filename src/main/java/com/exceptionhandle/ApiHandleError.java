package com.exceptionhandle;

import com.exception.ApiRequestException;
import com.exception.ApiRequestSuccessfull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
class ApiHandleError extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleException(ApiRequestException e){
        ApiException apiRequestException =
                new ApiException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, new Timestamp(System.currentTimeMillis()));

        return new ResponseEntity<>(apiRequestException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {ApiRequestSuccessfull.class})
    public ResponseEntity<Object> handleSuccessful(ApiRequestSuccessfull e){
        ApiException apiRequestException =
                new ApiException(e.getMessage(),HttpStatus.OK, new Timestamp(System.currentTimeMillis()));

        return new ResponseEntity<>(apiRequestException, HttpStatus.resolve(200));
    }

}
