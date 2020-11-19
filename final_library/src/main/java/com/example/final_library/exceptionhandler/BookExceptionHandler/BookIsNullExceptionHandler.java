package com.example.final_library.exceptionhandler.BookExceptionHandler;

import com.example.final_library.exception.bookexception.BookIsNullException;
import com.example.final_library.model.Book;
import com.example.final_library.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class BookIsNullExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = BookIsNullException.class)
    public ResponseEntity<Response<Book>> bookIsNullExHandler(BookIsNullException bookIsNullException){
        Response<Book> response = new Response<>(HttpStatus.BAD_REQUEST,bookIsNullException.getMessage(),null);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
