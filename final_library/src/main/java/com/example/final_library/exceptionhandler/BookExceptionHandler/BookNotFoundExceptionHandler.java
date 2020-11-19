package com.example.final_library.exceptionhandler.BookExceptionHandler;

import com.example.final_library.exception.bookexception.BookNotFoundException;
import com.example.final_library.model.Book;
import com.example.final_library.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookNotFoundExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Response<Book>> bookHandleException(BookNotFoundException bookNotFoundException){

        Response<Book> response = new Response<>(HttpStatus.NOT_FOUND,bookNotFoundException.getMessage(),null);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
