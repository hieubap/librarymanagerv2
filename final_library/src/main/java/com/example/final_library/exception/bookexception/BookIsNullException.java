package com.example.final_library.exception.bookexception;

public class BookIsNullException extends RuntimeException {
    public BookIsNullException() {
        super("all field of book is not null");
    }
}
