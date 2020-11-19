package com.example.final_library.exception.bookexception;

public class BookExistException extends RuntimeException{
    public BookExistException() {
        super("Book is exist");
    }
}
