package com.example.final_library.exceptionhandler.BookExceptionHandler;

import com.example.final_library.exception.bookexception.BookExistException;
import com.example.final_library.model.Book;
import com.example.final_library.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookExistExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = BookExistException.class)
    public ResponseEntity<Response<Book>> bookExistExceptionHandler(BookExistException bookExistException) {
        Response<Book> bookResponse = new Response<>(HttpStatus.BAD_REQUEST, bookExistException.getMessage(), null);
        return new ResponseEntity<>(bookResponse,HttpStatus.BAD_REQUEST);
    }
}
