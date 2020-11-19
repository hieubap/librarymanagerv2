package com.example.final_library.exceptionhandler.BookRentalHandlerException;

import com.example.final_library.exception.bookrentalexception.BookRentalIsNullException;
import com.example.final_library.model.BookRental;
import com.example.final_library.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class BookRentalIsNullExceptionHandler {
    @ExceptionHandler(value = BookRentalIsNullException.class)
    public ResponseEntity<Response<BookRental>> bookRentalIsNullExHandler(BookRentalIsNullException bookRentalIsNullException){
        Response<BookRental> response = new Response<>(HttpStatus.BAD_REQUEST,bookRentalIsNullException.getMessage(),null);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
