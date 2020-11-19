package com.example.final_library.exceptionhandler.BookRentalHandlerException;

import com.example.final_library.exception.bookrentalexception.BookRentalNotFoundException;
import com.example.final_library.model.BookRental;
import com.example.final_library.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class BookRentalNotFoundExceptionHandler {
    @ExceptionHandler(value = {BookRentalNotFoundException.class})
    public ResponseEntity<Response<BookRental>> bookRentalHandleException(BookRentalNotFoundException bookRentalNotFoundException){

        Response<BookRental> response = new Response<>(HttpStatus.NOT_FOUND,bookRentalNotFoundException.getMessage(),null);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
