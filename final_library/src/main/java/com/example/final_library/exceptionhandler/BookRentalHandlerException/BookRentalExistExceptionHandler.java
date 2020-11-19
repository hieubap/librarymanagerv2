package com.example.final_library.exceptionhandler.BookRentalHandlerException;

import com.example.final_library.exception.bookrentalexception.BookRentalExistException;
import com.example.final_library.model.BookRental;
import com.example.final_library.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookRentalExistExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = BookRentalExistException.class)
    public ResponseEntity<Response<BookRental>> bookRentalExistExceptionHandler(BookRentalExistException bookRentalExistException) {
        Response<BookRental> bookRentalResponse = new Response<>(HttpStatus.BAD_REQUEST, bookRentalExistException.getMessage(), null);
        return new ResponseEntity<>(bookRentalResponse,HttpStatus.BAD_REQUEST);
    }
}