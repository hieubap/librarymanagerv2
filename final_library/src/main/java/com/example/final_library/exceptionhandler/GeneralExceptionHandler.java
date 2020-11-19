package com.example.final_library.exceptionhandler;

import com.example.final_library.exception.generalexception.ServerError;
import com.example.final_library.model.Book;
import com.example.final_library.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ServerError.class})
    public ResponseEntity<Response<Book>> bookHandleException(ServerError serverError) {

        Response<Book> response = new Response<>(HttpStatus.INTERNAL_SERVER_ERROR,serverError.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

